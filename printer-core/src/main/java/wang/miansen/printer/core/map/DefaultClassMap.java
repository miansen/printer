package wang.miansen.printer.core.map;

import java.util.List;

import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * 用于描述源类与目标类的映射关系，通常这是 Printer 内部默认的映射。
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public class DefaultClassMap extends AbstractClassMap {

	public DefaultClassMap(PrinterClass sourceClass, PrinterClass targetClass, List<FieldMap> fieldMaps) {
		super(sourceClass, targetClass, fieldMaps);
	}

	@Override
	public String toString() {
		return "DefaultClassMap {getSourceClass()=" + getSourceClass() + ", getTargetClass()=" + getTargetClass() + "}";
	}

}
