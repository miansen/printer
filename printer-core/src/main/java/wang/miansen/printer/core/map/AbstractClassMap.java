package wang.miansen.printer.core.map;

import java.util.List;

import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * 用于描述源类与目标类的映射关系
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public abstract class AbstractClassMap implements ClassMap {

	/**
	 * 源类
	 */
	private final PrinterClass sourceClass;

	/**
	 * 目标类
	 */
	private final PrinterClass targetClass;

	/**
	 * 源字段与目标字段的映射关系
	 */
	private final List<AbstractFieldMap> fieldMaps;

	public AbstractClassMap(PrinterClass sourceClass, PrinterClass targetClass, List<AbstractFieldMap> fieldMaps) {
		this.sourceClass = sourceClass;
		this.targetClass = targetClass;
		this.fieldMaps = fieldMaps;
	}

	public PrinterClass getSourceClass() {
		return sourceClass;
	}

	public PrinterClass getTargetClass() {
		return targetClass;
	}

	public List<AbstractFieldMap> getFieldMaps() {
		return fieldMaps;
	}

	@Override
	public String toString() {
		return "ClassMap {sourceClass=" + sourceClass + ", targetClass=" + targetClass + "}";
	}

}
