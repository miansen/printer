package wang.miansen.printer.core.map;

import wang.miansen.printer.core.metadata.PrinterField;

/**
 * 字段映射关系接口
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public interface FieldMap {

	/**
	 * 获取来源 PrinterField
	 * @return {@link PrinterField}
	 */
	PrinterField getSourceField();

	/**
	 * 获取目标 PrinterField
	 * @return {@link PrinterField}
	 */
	PrinterField getTargetField();

	/**
	 * 获取类映射关系
	 * 
	 * @return {@link ClassMap}
	 */
	ClassMap getClassMap();

}
