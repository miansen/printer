package wang.miansen.printer.core;

import wang.miansen.printer.core.director.FieldMapBuildDirector;

/**
 * 字段级别的映射选项接口
 * 
 * @author miansen.wang
 * @date 2020-03-24
 */
public interface FieldMappingOption {

	void apply(FieldMapBuildDirector.FieldMapBuilder fieldMapBuilder);
	
}
