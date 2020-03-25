package wang.miansen.printer.core;

import wang.miansen.printer.core.builder.ClassMappingBuilder;

/**
 * @author miansen.wang
 * @date 2020-03-24
 */
public interface ClassMappingOption {

	void apply(ClassMappingBuilder classMappingBuilder);
	
}
