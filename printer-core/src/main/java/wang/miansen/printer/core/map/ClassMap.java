package wang.miansen.printer.core.map;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * Class 映射类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class ClassMap {

	private PrinterClass sourceClass;

	private PrinterClass targetClass;

	private List<FieldMap> fieldMaps = new ArrayList<>();

	public PrinterClass getSourceClass() {
		return sourceClass;
	}

	public void setSourceClass(PrinterClass sourceClass) {
		this.sourceClass = sourceClass;
	}

	public PrinterClass getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(PrinterClass targetClass) {
		this.targetClass = targetClass;
	}

	public List<FieldMap> getFieldMaps() {
		return fieldMaps;
	}

	public void setFieldMaps(List<FieldMap> fieldMaps) {
		this.fieldMaps = fieldMaps;
	}

	@Override
	public String toString() {
		return "ClassMap {sourceClass=" + sourceClass + ", targetClass=" + targetClass + "}";
	}

}
