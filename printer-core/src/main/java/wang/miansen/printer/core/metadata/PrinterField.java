package wang.miansen.printer.core.metadata;

import wang.miansen.printer.core.propertydescriptor.PrinterPropertyDescriptor;

/**
 * Printer 内部的字段描述类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterField {

	/**
	 * 字段所属的类
	 */
	private Class<?> clazz;

	/**
	 * 字段的名字
	 */
	private String name;

	/**
	 * 字段的类型
	 */
	private Class<?> type;

	/**
	 * 字段的属性描述符
	 */
	private PrinterPropertyDescriptor printerPropertyDescriptor;

	PrinterField() {

	}

	public Class<?> getClazz() {
		return clazz;
	}

	void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	void setType(Class<?> type) {
		this.type = type;
	}

	public PrinterPropertyDescriptor getPrinterPropertyDescriptor() {
		return printerPropertyDescriptor;
	}

	void setPrinterPropertyDescriptor(PrinterPropertyDescriptor printerPropertyDescriptor) {
		this.printerPropertyDescriptor = printerPropertyDescriptor;
	}

	@Override
	public String toString() {
		return "PrinterField {name=" + name + ", type=" + type + "}";
	}

}
