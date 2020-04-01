package wang.miansen.printer.core.map;

import wang.miansen.printer.core.metadata.PrinterField;

/**
 * 用于描述默认字段的映射关系，通常这是 Printer 内部默认的映射。
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public class DefaultFieldMap extends AbstractFieldMap {

	public DefaultFieldMap(PrinterField sourceField, PrinterField targetField, ClassMap classMap) {
		super(sourceField, targetField, classMap);
	}

	@Override
	public String toString() {
		return "DefaultFieldMap {sourceField=" + getSourceField() + ", targetField=" + getTargetField() + "}";
	}

}
