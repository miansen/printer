package wang.miansen.printer.core.director;

import java.beans.IntrospectionException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.FieldMappingOption;
import wang.miansen.printer.core.DefaultMappingContext;
import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.beans.DefaultIntrospectionContext;
import wang.miansen.printer.core.beans.IntrospectionContext;
import wang.miansen.printer.core.beans.JavaBeanIntrospector;
import wang.miansen.printer.core.beans.PrinterIntrospector;
import wang.miansen.printer.core.beans.PrinterPropertyDescriptorFactory;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.CustomClassMap;
import wang.miansen.printer.core.map.DefaultClassMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterClassBuilder;
import wang.miansen.printer.core.util.CollectionUtils;
import wang.miansen.printer.core.util.MappingUtils;

/**
 * 此类用来生成各个类映射建造者，从而指挥各个建造者创建 {@link ClassMap} 对象
 * <p>请根据实际的情况，选择合适的建造者：
 * <ul>
 * <li>{@link #default_()}：构建默认的类映射的建造者</li>
 * <li>{@link #custom()}：构建自定义的类映射的建造者</li>
 * </ul>
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMapBuildDirector {
	
	private static final Logger logger = LoggerFactory.getLogger(ClassMapBuildDirector.class);

	/**
	 * 来源 Class
	 */
	private final Class<?> sourceClass;
	
	/**
	 * 目标 Class
	 */
	private final Class<?> targetClass;
	
	/**
	 * 类级别的映射
	 */
	private ClassMap classMap;
	
	private final DefaultMappingContext mappingContext;
	
	/**
	 * bean 映射构建器
	 */
	private final PrinterBeanMapperBuilder printerBeanMapperBuilder;
	
	/**
	 * 字段映射建造者
	 */
	private final List<FieldMapBuildDirector.FieldMapBuilder> fieldMapBuilders;
	
	/**
	 * 描述符工厂
	 */
	private final PrinterPropertyDescriptorFactory propertyDescriptorFactory;
	
	private final PrinterIntrospector introspector;
	
	public ClassMapBuildDirector(Class<?> sourceClass, Class<?> targetClass, DefaultMappingContext mappingContext) {
		this(sourceClass, targetClass, mappingContext, null);
	}
	
	public ClassMapBuildDirector(Class<?> sourceClass, Class<?> targetClass, DefaultMappingContext mappingContext, 
			PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
		this.mappingContext = mappingContext;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
		this.fieldMapBuilders = new ArrayList<>();
		this.propertyDescriptorFactory = new PrinterPropertyDescriptorFactory();
		this.introspector = JavaBeanIntrospector.instance();
	}

	/**
	 * 自定义字段映射
	 * 
	 * @param source 来源字段的名字
	 * @param target 目标字段的名字
	 * @param fieldMappingOptions 字段级别的映射选项
	 * @return ClassMapBuildDirector
	 */
	public ClassMapBuildDirector field(String source, String target, FieldMappingOption... fieldMappingOptions) {
		FieldMapBuildDirector fiBuilderDirector = new FieldMapBuildDirector(source, target, classMap, propertyDescriptorFactory);
		FieldMapBuildDirector.FieldMapBuilder customFieldMapBuilder = fiBuilderDirector.custom();
		for (FieldMappingOption fieldMappingOption : fieldMappingOptions) {
			fieldMappingOption.apply(customFieldMapBuilder);
		}
		fieldMapBuilders.add(customFieldMapBuilder);
		return this;
	}

	/**
	 * 排除不需要映射的字段
	 * 
	 * @param source 来源字段的名字
	 * @return ClassMapBuildDirector
	 */
	public ClassMapBuildDirector exclude(String source) {
		FieldMapBuildDirector fiBuilderDirector = new FieldMapBuildDirector(source, null, classMap, propertyDescriptorFactory);
		FieldMapBuildDirector.FieldMapBuilder excludeFieldMapBuilder = fiBuilderDirector.exclude();
		fieldMapBuilders.add(excludeFieldMapBuilder);
		return this;
	}

	/**
	 * 执行字段映射，以便完成整个类映射。
	 * 
	 * @return PrinterBeanMapperBuilder
	 */
	public PrinterBeanMapperBuilder ok() {
		if (loadable()) {
			// 加载默认的字段映射建造者
			loadDefaultFieldMap();
		}
		for (FieldMapBuildDirector.FieldMapBuilder fieldMapBuilder : fieldMapBuilders) {
			if (fieldMapBuilder.accept()) {
				fieldMapBuilder.build();
			}
		}
		return printerBeanMapperBuilder;
	}
	
	/**
	 * 加载默认的字段映射建造者
	 */
	private void loadDefaultFieldMap() {
		IntrospectionContext sourceContext = new DefaultIntrospectionContext(sourceClass);
		IntrospectionContext targetContext = new DefaultIntrospectionContext(targetClass);
		try {
			introspector.introspect(sourceContext);
			introspector.introspect(targetContext);
		} catch (IntrospectionException e) {
			logger.error("Error when load default field map. class: " + targetClass, e);
			return;
		}
		Set<String> propertyNames = CollectionUtils.intersection(sourceContext.propertyNames(), 
				targetContext.propertyNames());
		for (String propertyName : propertyNames) {
			if (MappingUtils.shouldIgnoreField(propertyName, sourceClass, targetClass)) {
				continue;
			}
			FieldMapBuildDirector fiBuilderDirector = new FieldMapBuildDirector(propertyName, propertyName, classMap, propertyDescriptorFactory);
			FieldMapBuildDirector.FieldMapBuilder defaultFieldMapBuilder = fiBuilderDirector.default_();
			fieldMapBuilders.add(defaultFieldMapBuilder);
		}
	}

	/**
	 * 判断是否可以加载默认的字段映射建造者
	 * 
	 * @return boolean
	 */
	private boolean loadable() {
		boolean loadable = false;
		if (classMap instanceof CustomClassMap) {
			CustomClassMap customClassMap = (CustomClassMap) classMap;
			Configuration classConfiguration = customClassMap.getClassConfiguration();
			loadable = classConfiguration.getWildcard();
		} else {
			Configuration globalConfiguration = mappingContext.getGlobalConfiguration();
			loadable = globalConfiguration.getWildcard();
		}
		return loadable;
	}

	/**
	 * 获取默认的类映射建造者
	 * 
	 * @return ClassMapBuilder
	 */
	public ClassMapBuilder default_() {
		return new DefaultClassMapBuilder();
	}
	
	/**
	 * 获取自定义的类映射建造者
	 * 
	 * @return ClassMapBuilder
	 */
	public ClassMapBuilder custom() {
		return new CustomClassMapBuilder();
	}
	
	/**
	 * 类映射建造者接口
	 */
	public interface ClassMapBuilder {
		
		/**
		 * 构建一个 {@link ClassMap} 对象
		 * 
		 * @return ClassMap
		 */
		ClassMap build();
		
	}
	
	/**
	 * 默认的类映射建造者
	 */
	public final class DefaultClassMapBuilder implements ClassMapBuilder {
		
		DefaultClassMapBuilder() {
			
		}

		@Override
		public ClassMap build() {
			PrinterClassBuilder sourcePrinterClassBuilder = new PrinterClassBuilder(sourceClass);
			PrinterClass sourcePrinterClass = sourcePrinterClassBuilder.build();
			PrinterClassBuilder targetPrinterClassBuilder = new PrinterClassBuilder(targetClass);
			PrinterClass targetPrinterClass = targetPrinterClassBuilder.build();
			List<FieldMap> fieldMaps = new ArrayList<>();
			classMap = new DefaultClassMap(sourcePrinterClass, targetPrinterClass, fieldMaps);
			return classMap;
		}
		
	}
	
	/**
	 * 自定义的类映射建造者
	 */
	public final class CustomClassMapBuilder implements ClassMapBuilder {
		
		CustomClassMapBuilder() {
			
		}

		/**
		 * 类级别的配置
		 */
		private Configuration classConfiguration = new Configuration();
		
		@Override
		public ClassMap build() {
			PrinterClassBuilder sourcePrinterClassBuilder = new PrinterClassBuilder(sourceClass);
			PrinterClass sourcePrinterClass = sourcePrinterClassBuilder.build();
			PrinterClassBuilder targetPrinterClassBuilder = new PrinterClassBuilder(targetClass);
			PrinterClass targetPrinterClass = targetPrinterClassBuilder.build();
			List<FieldMap> fieldMaps = new ArrayList<>();
			CustomClassMap customClassMap = new CustomClassMap(sourcePrinterClass, targetPrinterClass, fieldMaps);
			customClassMap.setClassConfiguration(classConfiguration);
			classMap = customClassMap;
			return classMap;
		}

		public Configuration getClassConfiguration() {
			return classConfiguration;
		}

		public void setClassConfiguration(Configuration classConfiguration) {
			this.classConfiguration = classConfiguration;
		}
		
	}
	
}
