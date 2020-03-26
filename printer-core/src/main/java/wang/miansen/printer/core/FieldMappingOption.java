package wang.miansen.printer.core;

import wang.miansen.printer.core.builder.FieldMapBuilderDirector;

/**
 * @author miansen.wang
 * @date 2020-03-24
 */
public interface FieldMappingOption {

	void apply(FieldMapBuilderDirector.FieldMapBuilder fieldMapBuilder);
	
}
