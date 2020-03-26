package wang.miansen.printer.core;

import wang.miansen.printer.core.director.ClassMapBuildDirector;

/**
 * 类级别的映射选项接口
 * 
 * @author miansen.wang
 * @date 2020-03-24
 */
public interface ClassMappingOption {

	void apply(ClassMapBuildDirector.ClassMapBuilder classMapBuilder);
	
}
