package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.builder.TypeMappingBuilder;
import wang.miansen.printer.core.converters.ConverterContainer;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public class PrinterBeanMapperBuilder {

	private ClassMap classMap;

	private List<FieldMap> fieldMaps;

	private MappingContext mappingContext;

	private PrinterBeanMapperBuilder() {
		mappingContext = new MappingContext();
	}

	public static PrinterBeanMapperBuilder create() {
		return new PrinterBeanMapperBuilder();
	}

	public PrinterBeanMapperBuilder mapping(Class<?> typeA, Class<?> typeB) {
		fieldMaps = new ArrayList<>();
		classMap = new ClassMap();
		PrinterClass a = new PrinterClass(typeA);
		PrinterClass b = new PrinterClass(typeB);
		classMap.setSrcClass(a);
		classMap.setDestClass(b);
		classMap.setFieldMaps(fieldMaps);
		mappingContext.addClassMap(classMap);
		return this;
	}

	public PrinterBeanMapperBuilder fields(String a, String b) {
		PrinterField printerFieldA = new PrinterField();
		PrinterField printerFieldB = new PrinterField();
		printerFieldA.setName(a);
		printerFieldB.setName(b);
		FieldMap fieldMap = new FieldMap();
		fieldMap.setSrcField(printerFieldA);
		fieldMap.setDestField(printerFieldB);
		fieldMaps.add(fieldMap);
		return this;
	}

	public PrinterBeanMapper build() {
		return new PrinterBeanMapper(mappingContext);

	}

}
