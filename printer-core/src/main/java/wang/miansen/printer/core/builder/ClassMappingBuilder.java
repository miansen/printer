package wang.miansen.printer.core.builder;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.map.AbstractClassMap;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMappingBuilder implements BeanMappingBuilder {

	private final PrinterBeanMapperBuilder printerBeanMapperBuilder;
	
	private final AbstractClassMap classMap;
	
	private final List<BeanMappingBuilder> fieldMappingBuilders;

	public ClassMappingBuilder(AbstractClassMap classMap, PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.classMap = classMap;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
		this.fieldMappingBuilders = new ArrayList<>();
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
