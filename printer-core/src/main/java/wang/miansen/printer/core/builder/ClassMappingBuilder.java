package wang.miansen.printer.core.builder;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import wang.miansen.printer.core.FieldMappingOption;
import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.map.AbstractClassMap;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.propertydescriptor.PropertyDescriptorFactory;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMappingBuilder implements BeanMappingBuilder {

	private final PrinterBeanMapperBuilder printerBeanMapperBuilder;
	
	private final ClassMap classMap;
	
	private final List<FieldMapBuilder> fieldMapBuilders;
	
	private final PropertyDescriptorFactory propertyDescriptorFactory;

	public ClassMappingBuilder(ClassMap classMap, PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.classMap = classMap;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
		this.fieldMapBuilders = new ArrayList<>();
		this.propertyDescriptorFactory = new PropertyDescriptorFactory();
	}

	public ClassMappingBuilder field(String source, String target, FieldMappingOption... fieldMappingOptions) {
		FieldMapBuilder fieldMapBuilder = new FieldMapBuilder(source, target, classMap, propertyDescriptorFactory);
		for (FieldMappingOption fieldMappingOption : fieldMappingOptions) {
			fieldMappingOption.apply(fieldMapBuilder);
		}
		fieldMapBuilders.add(fieldMapBuilder);
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
