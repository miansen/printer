package wang.miansen.printer.core.builder;

import java.util.List;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.MappingContext;
import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMappingBuilder implements BeanMappingBuilder {

	private List<FieldMap> fieldMaps;

	private PrinterBeanMapperBuilder printerBeanMapperBuilder;
	
	private ClassMap classMap;
	
	private List<ClassMap> classMaps;
	
	private List<BeanMappingBuilder> fieldMappingBuilders;
	
	private Configuration classConfiguration;

	public ClassMappingBuilder(ClassMap classMap, PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.classMap = classMap;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
	}

	public ClassMappingBuilder field(String source, String target, FieldMappingOption... fieldMappingOptions) {
		FieldMappingBuilder fieldMappingBuilder = new FieldMappingBuilder(classMap, source, target);
		for (FieldMappingOption fieldMappingOption : fieldMappingOptions) {
			fieldMappingOption.apply(fieldMappingBuilder);
		}
		fieldMappingBuilders.add(fieldMappingBuilder);
		return this;
	}

	public ClassMappingBuilder exclude(String field) {
		return this;
	}

	public PrinterBeanMapperBuilder ok() {
		return printerBeanMapperBuilder;
	}
	
	public void addDefaultFieldMappings() {
		
	}

	@Override
	public void build() {
		for (BeanMappingBuilder fiBeanMappingBuilder : fieldMappingBuilders) {
			fiBeanMappingBuilder.build();
		}
	}
	
}
