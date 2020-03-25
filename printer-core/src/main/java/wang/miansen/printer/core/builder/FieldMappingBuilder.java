package wang.miansen.printer.core.builder;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.MappingContext;
import wang.miansen.printer.core.map.AbstractClassMap;
import wang.miansen.printer.core.map.AbstractFieldMap;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * @author miansen.wang
 * @date 2020-03-23
 */
public class FieldMappingBuilder implements BeanMappingBuilder {

	private AbstractClassMap classMap;
	
	private String source;
	
	private String target;
	
	private Configuration classConfiguration;
	
	public FieldMappingBuilder(AbstractClassMap classMap, String source, String target) {
		this.classMap = classMap;
		this.source = source;
		this.target = target;
	}

	@Override
	public void build() {
		
	}
	
}
