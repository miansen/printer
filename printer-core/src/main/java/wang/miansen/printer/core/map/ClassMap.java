package wang.miansen.printer.core.map;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class ClassMap {

	private PrinterClass srcClass;

	private PrinterClass destClass;

	private List<FieldMap> fieldMaps = new ArrayList<>();

	public PrinterClass getSrcClass() {
		return srcClass;
	}

	public void setSrcClass(PrinterClass srcClass) {
		this.srcClass = srcClass;
	}

	public PrinterClass getDestClass() {
		return destClass;
	}

	public void setDestClass(PrinterClass destClass) {
		this.destClass = destClass;
	}

	public List<FieldMap> getFieldMaps() {
		return fieldMaps;
	}

	public void setFieldMaps(List<FieldMap> fieldMaps) {
		this.fieldMaps = fieldMaps;
	}

	@Override
	public String toString() {
		return "ClassMap [srcClass=" + srcClass + ", destClass=" + destClass + ", fieldMaps=" + fieldMaps + "]";
	}

}
