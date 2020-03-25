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

	PrinterClass getSourceClass();
	
	PrinterClass getTargetClass();
	
	List<FieldMap> getFieldMaps();
	
}
