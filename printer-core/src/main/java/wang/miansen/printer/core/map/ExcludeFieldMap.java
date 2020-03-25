package wang.miansen.printer.core.map;

import wang.miansen.printer.core.metadata.PrinterField;

/**
 * 用户指定排除映射的字段
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public class ExcludeFieldMap extends AbstractFieldMap {

	public ExcludeFieldMap(PrinterField sourceField, PrinterField targetField, ClassMap classMap) {
		super(sourceField, targetField, classMap);
	}

	@Override
	public String toString() {
		return "ExcludeFieldMap {getSourceField()=" + getSourceField() + ", getTargetField()=" + getTargetField() + "}";
	}

}
