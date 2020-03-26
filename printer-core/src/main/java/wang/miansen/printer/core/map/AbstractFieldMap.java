package wang.miansen.printer.core.map;

import wang.miansen.printer.core.metadata.PrinterField;

/**
 * 用于描述字段映射关系的抽象类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public abstract class AbstractFieldMap implements FieldMap {

	/**
	 * 来源字段
	 */
	private final PrinterField sourceField;

	/**
	 * 目标字段
	 */
	private final PrinterField targetField;
	
	/**
	 * 类映射
	 */
	private final ClassMap classMap;

	public AbstractFieldMap(PrinterField sourceField, PrinterField targetField, ClassMap classMap) {
		this.sourceField = sourceField;
		this.targetField = targetField;
		this.classMap = classMap;
	}

	public PrinterField getSourceField() {
		return sourceField;
	}

	public PrinterField getTargetField() {
		return targetField;
	}

	public ClassMap getClassMap() {
		return classMap;
	}

}
