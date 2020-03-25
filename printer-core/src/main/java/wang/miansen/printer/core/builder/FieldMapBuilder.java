package wang.miansen.printer.core.builder;

import java.util.List;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.CustomFieldMap;
import wang.miansen.printer.core.map.DefaultFieldMap;
import wang.miansen.printer.core.map.ExcludeFieldMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterField;
import wang.miansen.printer.core.metadata.PrinterFieldBuilder;
import wang.miansen.printer.core.propertydescriptor.PropertyDescriptorFactory;

/**
 * 用于创建 {@link FieldMap} 对象
 * <p>请根据实际的情况，选择合适的构造器 -> {@link #default_()} | {@link #custom()} | {@link #exclude()}
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public class FieldMapBuilder {

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
	private final PropertyDescriptorFactory propertyDescriptorFactory;
	
	/**
	 * 字段映射级别的配置
	 */
	private Configuration fieldConfiguration;
	
	public FieldMapBuilder(String sourceFieldName, String targetFieldName, ClassMap classMap, PropertyDescriptorFactory propertyDescriptorFactory) {
		this.sourceFieldName = sourceFieldName;
		this.targetFieldName = targetFieldName;
		this.classMap = classMap;
		this.propertyDescriptorFactory = propertyDescriptorFactory;
	}

	/**
	 * 用于创建 {@link DefaultFieldMap} 对象
	 * @return
	 */
	public DefaultFieldMapBuilder default_() {
		return new DefaultFieldMapBuilder();
	}
	
	/**
	 * 用于创建 {@link CustomFieldMap} 对象
	 * @return
	 */
	public CustomFieldMapBuilder custom() {
		return new CustomFieldMapBuilder();
	}
	
	/**
	 * 用于创建 {@link ExcludeFieldMap} 对象
	 * @return
	 */
	public ExcludeFieldMapBuilder exclude() {
		return new ExcludeFieldMapBuilder();
	}
	
	class DefaultFieldMapBuilder {
		
		public void build() {
			PrinterClass sourceClass = classMap.getSourceClass();
			PrinterClass targetClass = classMap.getTargetClass();
			List<FieldMap> fieldMaps = FieldMapBuilder.this.classMap.getFieldMaps();
			PrinterFieldBuilder sourcePrinterFieldBuilder = new PrinterFieldBuilder(sourceClass, sourceFieldName, propertyDescriptorFactory);
			PrinterField sourceField = sourcePrinterFieldBuilder.build();
			PrinterFieldBuilder targetPrinterFieldBuilder = new PrinterFieldBuilder(targetClass, targetFieldName, propertyDescriptorFactory);
			PrinterField targetField = targetPrinterFieldBuilder.build();
			FieldMap fieldMap = new DefaultFieldMap(sourceField, targetField, classMap);
			fieldMaps.add(fieldMap);
		}
		
	}
	
	class CustomFieldMapBuilder {
		
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
		
	}
	
	class ExcludeFieldMapBuilder {
		
		public void build() {
			PrinterClass sourceClass = classMap.getSourceClass();
			List<FieldMap> fieldMaps = classMap.getFieldMaps();
			PrinterFieldBuilder sourcePrinterFieldBuilder = new PrinterFieldBuilder(sourceClass, sourceFieldName, propertyDescriptorFactory);
			PrinterField sourceField = sourcePrinterFieldBuilder.build();
			FieldMap excludeFieldMap = new ExcludeFieldMap(sourceField, null, classMap);
			fieldMaps.add(excludeFieldMap);
		}
		
	}
	
}
