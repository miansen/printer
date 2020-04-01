package wang.miansen.printer.core.map;

import java.util.List;

import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.util.CollectionUtils;

/**
 * 用于描述源类与目标类的映射关系
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public abstract class AbstractClassMap implements ClassMap {

	/**
	 * 源类
	 */
	private final PrinterClass sourceClass;

	/**
	 * 目标类
	 */
	private final PrinterClass targetClass;

	/**
	 * 源字段与目标字段的映射关系
	 */
	private final List<FieldMap> fieldMaps;

	public AbstractClassMap(PrinterClass sourceClass, PrinterClass targetClass, List<FieldMap> fieldMaps) {
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
		this.fieldMaps = fieldMaps;
	}

	public PrinterClass getSourceClass() {
		return sourceClass;
	}

	public PrinterClass getTargetClass() {
		return targetClass;
	}

	public List<FieldMap> getFieldMaps() {
		return fieldMaps;
	}

	@Override
	public FieldMap getFieldMapBySourceFieldName(String sourceFieldName) {
		if (CollectionUtils.isEmpty(fieldMaps)) {
			return null;
		}
		FieldMap result = null;
		for (FieldMap fieldMap : fieldMaps) {
			String fieldName = fieldMap.getSourceField().getName();
			if (fieldName.equals(sourceFieldName)) {
				result = fieldMap;
				break;
			}
		}
		return result;
	}

	@Override
	public FieldMap getFieldMapByTargetFieldName(String targetFieldName) {
		if (CollectionUtils.isEmpty(fieldMaps)) {
			return null;
		}
		FieldMap result = null;
		for (FieldMap fieldMap : fieldMaps) {
			String fieldName = fieldMap.getTargetField().getName();
			if (fieldName.equals(targetFieldName)) {
				result = fieldMap;
				break;
			}
		}
		return result;
	}

}
