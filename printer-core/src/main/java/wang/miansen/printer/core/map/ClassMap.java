package wang.miansen.printer.core.map;

import java.util.List;

import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * 类映射关系接口
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public interface ClassMap {

	/**
	 * 获取来源 PrinterClass
	 * 
	 * @return {@link PrinterClass}
	 */
	PrinterClass getSourceClass();
	
	/**
	 * 获取目标 PrinterClass
	 * 
	 * @return {@link PrinterClass}
	 */
	PrinterClass getTargetClass();
	
	/**
	 * 获取字段映射关系
	 * 
	 * @return {@link FieldMap}
	 */
	List<FieldMap> getFieldMaps();
	
	/**
	 * 根据输入的来源字段名称获取相应的字段映射
	 * 
	 * @param sourceFieldName 来源字段名称
	 * @return FieldMap
	 */
	FieldMap getFieldMapBySourceFieldName(String sourceFieldName);
	
	/**
	 * 根据输入的目标字段名称获取相应的字段映射
	 * 
	 * @param targetFieldName 目标字段名称
	 * @return FieldMap
	 */
	FieldMap getFieldMapByTargetFieldName(String targetFieldName);
	
}
