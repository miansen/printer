package wang.miansen.printer.core.director;

import java.util.List;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.beans.PrinterPropertyDescriptorFactory;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.CustomFieldMap;
import wang.miansen.printer.core.map.DefaultFieldMap;
import wang.miansen.printer.core.map.ExcludeFieldMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterField;
import wang.miansen.printer.core.metadata.PrinterFieldBuilder;

/**
 * 此类用来生成各个字段映射建造者，从而指挥各个建造者创建 {@link FieldMap} 对象
 * <p>请根据实际的情况，选择合适的建造者：
 * <ul>
 * <li>{@link #default_()}：创建默认的字段映射的建造者</li>
 * <li>{@link #custom()}：创建自定义字段映射的建造者</li>
 * <li>{@link #exclude()}：创建排除字段映射的建造者</li>
 * </ul>
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public final class FieldMapBuildDirector {

	/**
	 * 来源字段的名字
	 */
	private final String sourceFieldName;
	
	/**
	 * 目标字段的名字
	 */
	private final String targetFieldName;
	
	/**
	 * 类映射
	 */
	private final ClassMap classMap;
	
	/**
	 * 属性描述符工厂
	 */
	private final PrinterPropertyDescriptorFactory propertyDescriptorFactory;
	
	/**
	 * 创建一个指挥者对象
	 * 
	 * @param sourceFieldName 来源字段的名字
	 * @param targetFieldName 目标字段的名字
	 * @param classMap 类映射
	 * @param propertyDescriptorFactory 属性描述符工厂
	 */
	public FieldMapBuildDirector(String sourceFieldName, String targetFieldName, ClassMap classMap, PrinterPropertyDescriptorFactory propertyDescriptorFactory) {
		this.sourceFieldName = sourceFieldName;
		this.targetFieldName = targetFieldName;
		this.classMap = classMap;
		this.propertyDescriptorFactory = propertyDescriptorFactory;
	}

	/**
	 * 获取默认的字段映射建造者
	 * 
	 * @return FieldMapBuilder
	 */
	public FieldMapBuilder default_() {
		return new DefaultFieldMapBuilder();
	}
	
	/**
	 * 获取自定义字段映射建造者
	 * 
	 * @return FieldMapBuilder
	 */
	public FieldMapBuilder custom() {
		return new CustomFieldMapBuilder();
	}
	
	/**
	 * 获取排除字段映射建造者
	 * 
	 * @return FieldMapBuilder
	 */
	public FieldMapBuilder exclude() {
		return new ExcludeFieldMapBuilder();
	}
	
	/**
	 * 字段映射建造者接口
	 */
	public interface FieldMapBuilder {
		
		/**
		 * 此方法用来判断是否可以构建字段映射。
		 * <p>调用 {@code build()} 方法执行之前应该先调用此方法，以此来判断是否可以构建字段映射。
		 * <p>如果不先调用此方法而直接调用 {@code build()} 方法，可能会造成字段重复映射。
		 * 
		 * @return boolean 返回 true 说明可以构建字段映射
		 */
		boolean accept();
		
		/**
		 * 构建字段映射
		 */
		void build();
		
	}
	
	public abstract class AbstractFieldMapBuilder implements FieldMapBuilder {
		
		@Override
		public boolean accept() {
			if (classMap.getFieldMapBySourceFieldName(sourceFieldName) != null 
					|| classMap.getFieldMapByTargetFieldName(targetFieldName) != null) {
				return false;
			}
			return true;
		}
		
	}
	
	/**
	 * 默认的字段映射建造者
	 */
	public class DefaultFieldMapBuilder extends AbstractFieldMapBuilder {
		
		DefaultFieldMapBuilder() {
			
		}
		
		@Override
		public void build() {
			PrinterClass sourceClass = classMap.getSourceClass();
			PrinterClass targetClass = classMap.getTargetClass();
			List<FieldMap> fieldMaps = FieldMapBuildDirector.this.classMap.getFieldMaps();
			PrinterFieldBuilder sourceFieldBuilder = new PrinterFieldBuilder(sourceClass, sourceFieldName, propertyDescriptorFactory);
			PrinterField sourceField = sourceFieldBuilder.build();
			PrinterFieldBuilder targetFieldBuilder = new PrinterFieldBuilder(targetClass, targetFieldName, propertyDescriptorFactory);
			PrinterField targetField = targetFieldBuilder.build();
			FieldMap fieldMap = new DefaultFieldMap(sourceField, targetField, classMap);
			fieldMaps.add(fieldMap);
		}
	}
	
	/**
	 * 自定义字段映射建造者
	 */
	public class CustomFieldMapBuilder extends AbstractFieldMapBuilder {
		
		CustomFieldMapBuilder() {
			
		}

		/**
		 * 字段级别的配置
		 */
		private Configuration fieldConfiguration = new Configuration();
		
		@Override
		public void build() {
			PrinterClass sourceClass = classMap.getSourceClass();
			PrinterClass targetClass = classMap.getTargetClass();
			List<FieldMap> fieldMaps = classMap.getFieldMaps();
			PrinterFieldBuilder sourcePrinterFieldBuilder = new PrinterFieldBuilder(sourceClass, sourceFieldName, propertyDescriptorFactory);
			PrinterField sourceField = sourcePrinterFieldBuilder.build();
			PrinterFieldBuilder targetPrinterFieldBuilder = new PrinterFieldBuilder(targetClass, targetFieldName, propertyDescriptorFactory);
			PrinterField targetField = targetPrinterFieldBuilder.build();
			CustomFieldMap customFieldMap = new CustomFieldMap(sourceField, targetField, classMap);
			customFieldMap.setFieldConfiguration(fieldConfiguration);
			fieldMaps.add(customFieldMap);
		}

		public Configuration getFieldConfiguration() {
			return fieldConfiguration;
		}

		public void setFieldConfiguration(Configuration fieldConfiguration) {
			this.fieldConfiguration = fieldConfiguration;
		}
	}
	
	/**
	 * 排除字段映射建造者
	 */
	public class ExcludeFieldMapBuilder extends AbstractFieldMapBuilder {
		
		ExcludeFieldMapBuilder() {
			
		}
		
		@Override
		public void build() {
			PrinterClass sourceClass = classMap.getSourceClass();
			List<FieldMap> fieldMaps = classMap.getFieldMaps();
			PrinterFieldBuilder sourcePrinterFieldBuilder = new PrinterFieldBuilder(sourceClass, sourceFieldName, propertyDescriptorFactory);
			PrinterField excludeField = sourcePrinterFieldBuilder.build();
			FieldMap excludeFieldMap = new ExcludeFieldMap(excludeField, classMap);
			fieldMaps.add(excludeFieldMap);
		}
	}
	
}
