package wang.miansen.printer.core.metadata;

import java.lang.reflect.Field;

import wang.miansen.printer.core.propertydescriptor.PrinterPropertyDescriptor;

/**
 * Printer 内部用于描述映射字段的类，相当于对 {@link Field} 进一步封装。
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterField {

	/**
	 * 字段所属的类
	 */
	private PrinterClass printerClass;

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

	/**
	 * 请使用 {@link PrinterFieldBuilder} 创建对象
	 */
	PrinterField() {

	}

	public PrinterClass getPrinterClass() {
		return printerClass;
	}

	void setClazz(PrinterClass printerClass) {
		this.printerClass = printerClass;
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
