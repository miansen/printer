package wang.miansen.printer.core.map;

import java.util.List;

import wang.miansen.printer.core.Configuration;
import wang.miansen.printer.core.metadata.PrinterClass;

/**
 * 用于描述源类与目标类的映射关系，通常这是用户自定义的映射。
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public class CustomClassMap extends AbstractClassMap {

	/**
	 * 类级别的配置
	 */
	private Configuration classConfiguration;

	public CustomClassMap(PrinterClass sourceClass, PrinterClass targetClass, List<FieldMap> fieldMaps) {
		super(sourceClass, targetClass, fieldMaps);
	}

	public Configuration getClassConfiguration() {
		return classConfiguration;
	}

	public void setClassConfiguration(Configuration classConfiguration) {
		this.classConfiguration = classConfiguration;
	}

	@Override
	public String toString() {
		return "CustomClassMap {getSourceClass()=" + getSourceClass() + ", getTargetClass()=" + getTargetClass() + "}";
	}

}
