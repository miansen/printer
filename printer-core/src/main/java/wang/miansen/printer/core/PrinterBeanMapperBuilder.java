package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.builder.BeanMappingBuilder;
import wang.miansen.printer.core.builder.ClassMappingBuilder;
import wang.miansen.printer.core.builder.ClassMappingOption;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public class PrinterBeanMapperBuilder {

	private ClassMap classMap;

	private List<FieldMap> fieldMaps;

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
		classMap = new ClassMap();
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
