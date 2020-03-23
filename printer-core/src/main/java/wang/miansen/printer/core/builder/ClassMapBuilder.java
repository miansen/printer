package wang.miansen.printer.core.builder;

import java.util.List;

import wang.miansen.printer.core.PrinterBeanMapperBuilder;
import wang.miansen.printer.core.map.FieldMap;
import wang.miansen.printer.core.metadata.PrinterField;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public final class ClassMapBuilder {

	private List<FieldMap> fieldMaps;

	private PrinterBeanMapperBuilder printerBeanMapperBuilder;

	public ClassMapBuilder(List<FieldMap> fieldMaps, PrinterBeanMapperBuilder printerBeanMapperBuilder) {
		this.fieldMaps = fieldMaps;
		this.printerBeanMapperBuilder = printerBeanMapperBuilder;
	}

	public ClassMapBuilder fields(String a, String b) {
		PrinterField printerFieldA = new PrinterField();
		PrinterField printerFieldB = new PrinterField();
		printerFieldA.setName(a);
		printerFieldB.setName(b);
		FieldMap fieldMap = new FieldMap();
		fieldMap.setSourceField(printerFieldA);
		fieldMap.setTargetField(printerFieldB);
		fieldMaps.add(fieldMap);
		return this;
	}

	public ClassMapBuilder exclude(String field) {
		return this;
	}

	public PrinterBeanMapperBuilder ok() {
		return printerBeanMapperBuilder;
	}
	
	public void addDefaultFieldMappings() {
		
	}
	
}
