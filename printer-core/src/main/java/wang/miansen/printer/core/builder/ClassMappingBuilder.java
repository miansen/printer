package wang.miansen.printer.core.builder;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.FieldMappingOption;
import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.propertydescriptor.PropertyDescriptorFactory;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMappingBuilder implements BeanMappingBuilder {

	private final PrinterBeanMapperBuilder printerBeanMapperBuilder;
	
	private final ClassMap classMap;
	
	private final List<FieldMapBuilderDirector.FieldMapBuilder> fieldMapBuilders;
	
	private final PropertyDescriptorFactory propertyDescriptorFactory;

	public ClassMappingBuilder(ClassMap classMap, PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.classMap = classMap;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
		this.fieldMapBuilders = new ArrayList<>();
		this.propertyDescriptorFactory = new PropertyDescriptorFactory();
	}

	public ClassMappingBuilder field(String source, String target, FieldMappingOption... fieldMappingOptions) {
		FieldMapBuilderDirector fiBuilderDirector = new FieldMapBuilderDirector(source, target, classMap, propertyDescriptorFactory);
		FieldMapBuilderDirector.FieldMapBuilder customFieldMapBuilder = fiBuilderDirector.custom();
		for (FieldMappingOption fieldMappingOption : fieldMappingOptions) {
			fieldMappingOption.apply(customFieldMapBuilder);
		}
		fieldMapBuilders.add(customFieldMapBuilder);
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
		for (FieldMapBuilderDirector.FieldMapBuilder fieldMapBuilder : fieldMapBuilders) {
			fieldMapBuilder.build();
		}
	}
	
}
