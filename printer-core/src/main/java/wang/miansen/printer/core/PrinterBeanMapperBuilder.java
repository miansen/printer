package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.builder.BeanMappingBuilder;
import wang.miansen.printer.core.builder.ClassMappingBuilder;
import wang.miansen.printer.core.map.AbstractClassMap;
import wang.miansen.printer.core.map.AbstractFieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public class PrinterBeanMapperBuilder {

	private AbstractClassMap classMap;

	private List<AbstractFieldMap> fieldMaps;

	private MappingContext mappingContext;
	
	private List<BeanMappingBuilder> classMappingBuilder;

	private PrinterBeanMapperBuilder() {
		mappingContext = new MappingContext();
		classMappingBuilder = new ArrayList<>();
	}

	public static PrinterBeanMapperBuilder create() {
		return new PrinterBeanMapperBuilder();
	}

	public ClassMappingBuilder mapping(Class<?> typeA, Class<?> typeB, ClassMappingOption... option) {
		fieldMaps = new ArrayList<>();
		classMap = new AbstractClassMap();
		PrinterClass a = new PrinterClass(typeA);
		PrinterClass b = new PrinterClass(typeB);
		classMap.setSrcClass(a);
		classMap.setDestClass(b);
		classMap.setFieldMaps(fieldMaps);
		mappingContext.addClassMap(classMap);
		return new ClassMappingBuilder(classMap, this);
	}

	public PrinterBeanMapper build() {
		return new PrinterBeanMapper(mappingContext);
	}

}
