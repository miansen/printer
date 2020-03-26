package wang.miansen.printer.core.metadata;

import java.lang.reflect.Field;

import wang.miansen.printer.core.beans.PrinterPropertyDescriptor;

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

	/**
	 * 获取 {@link PrinterClass}
	 * 
	 * @return PrinterClass
	 */
	public PrinterClass getPrinterClass() {
		return printerClass;
	}

	/**
	 * 设置 {@link PrinterClass}
	 * 
	 * @param printerClass
	 */
	void setClazz(PrinterClass printerClass) {
		this.printerClass = printerClass;
	}

	/**
	 * 获取字段的名字
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置字段的名字
	 * 
	 * @param name 字段的名字
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取字段的类型
	 * 
	 * @return Class
	 */
	public Class<?> getType() {
		return type;
	}

	/**
	 * 设置字段的类型
	 * 
	 * @param type 字段的类型
	 */
	void setType(Class<?> type) {
		this.type = type;
	}

	/**
	 * 获取字段的属性描述符
	 * 
	 * @return PrinterPropertyDescriptor
	 */
	public PrinterPropertyDescriptor getPrinterPropertyDescriptor() {
		return printerPropertyDescriptor;
	}

	/**
	 * 设置字段的属性描述符
	 * @param printerPropertyDescriptor 属性描述符
	 */
	void setPrinterPropertyDescriptor(PrinterPropertyDescriptor printerPropertyDescriptor) {
		this.printerPropertyDescriptor = printerPropertyDescriptor;
	}

	@Override
	public String toString() {
		return "PrinterField {name=" + name + ", type=" + type + "}";
	}

}
