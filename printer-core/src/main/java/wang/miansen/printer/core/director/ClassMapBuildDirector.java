package wang.miansen.printer.core.director;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.FieldMappingOption;
import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.beans.PrinterPropertyDescriptorFactory;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.CustomClassMap;
import wang.miansen.printer.core.map.DefaultClassMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterClassBuilder;

/**
 * 指挥各个建造者创建 {@link ClassMap} 对象
 * <p>请根据实际的情况，选择合适的建造者 -> {@link #default_()} | {@link #custom()}
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMapBuildDirector {

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
	
	/**
	 * 创建指挥者的实例对象
	 * 
	 * @param sourceClass 来源 Class
	 * @param targetClass 目标 Class
	 * @param printerBeanMapperBuilder bean 映射构建器
	 */
	public ClassMapBuildDirector(Class<?> sourceClass, Class<?> targetClass, PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
		this.fieldMapBuilders = new ArrayList<>();
		this.propertyDescriptorFactory = new PrinterPropertyDescriptorFactory();
	}

	/**
	 * 指定字段的映射关系
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
	 * 构建完成，继续下一步
	 * 
	 * @return PrinterBeanMapperBuilder
	 */
	public PrinterBeanMapperBuilder ok() {
		for (FieldMapBuildDirector.FieldMapBuilder fieldMapBuilder : fieldMapBuilders) {
			fieldMapBuilder.build();
		}
		return printerBeanMapperBuilder;
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
