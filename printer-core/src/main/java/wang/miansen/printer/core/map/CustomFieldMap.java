package wang.miansen.printer.core.map;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * 用于描述字段映射关系的抽象类，通常这是用户自定义的映射。
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public class CustomFieldMap extends AbstractFieldMap {

	/**
	 * 字段级别的配置
	 */
	private Configuration fieldConfiguration;

	public CustomFieldMap(PrinterField sourceField, PrinterField targetField, ClassMap classMap) {
		super(sourceField, targetField, classMap);
	}

	public Configuration getFieldConfiguration() {
		return fieldConfiguration;
	}

	public void setFieldConfiguration(Configuration fieldConfiguration) {
		this.fieldConfiguration = fieldConfiguration;
	}

	@Override
	public String toString() {
		return "CustomFieldMap {getSourceField()=" + getSourceField() + ", getTargetField()=" + getTargetField() + "}";
	}

}
