package wang.miansen.printer.core.builder;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.MappingContext;
import wang.miansen.printer.core.map.ClassMap;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterClass;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class TypeMappingBuilder {

	private ClassMap classMap = new ClassMap();

	private List<FieldMap> fieldMaps = new ArrayList<>();

	private MappingContext mappingContext;

	public TypeMappingBuilder(ClassMap classMap) {
		this.classMap = classMap;
	}

	public TypeMappingBuilder(MappingContext mappingContext) {
		this.mappingContext = mappingContext;
	}

	public TypeMappingBuilder fields(String a, String b) {
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

	public TypeMappingBuilder mapping(Class<?> typeA, Class<?> typeB) {
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

	public TypeMappingBuilder ok() {
		this.fieldMaps = new ArrayList<>();
		this.classMap = new ClassMap();
		return this;
	}
}
