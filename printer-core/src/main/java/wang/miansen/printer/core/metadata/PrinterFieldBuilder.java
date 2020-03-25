package wang.miansen.printer.core.metadata;

import wang.miansen.printer.core.propertydescriptor.PrinterPropertyDescriptor;
import wang.miansen.printer.core.propertydescriptor.PropertyDescriptorFactory;

/**
 * 用于创建 {@link PrinterField} 对象
 * 
 * @author miansen.wang
 * @date 2020-03-24
 */
public class PrinterFieldBuilder {

	/**
	 * 字段所属的类
	 */
	private final Class<?> clazz;

	/**
	 * 字段的名字
	 */
	private final String name;

	/**
	 * 属性描述符工厂
	 */
	private final PropertyDescriptorFactory propertyDescriptorFactory;

	/**
	 * 创建一个 {@link PrinterFieldBuilder} 对象
	 * 
	 * @param clazz 字段所属的类
	 * @param name 字段的名字
	 * @param propertyDescriptorFactory 属性描述符工厂
	 */
	public PrinterFieldBuilder(Class<?> clazz, String name, PropertyDescriptorFactory propertyDescriptorFactory) {
		this.clazz = clazz;
		this.name = name;
		this.propertyDescriptorFactory = propertyDescriptorFactory;
	}

	/**
	 * 创建一个 {@link PrinterField} 对象
	 * 
	 * @return
	 */
	public PrinterField build() {
		PrinterPropertyDescriptor propertyDescriptor = this.propertyDescriptorFactory.getPropertyDescriptor(clazz, name);
		PrinterField printerField = new PrinterField();
		printerField.setClazz(this.clazz);
		printerField.setName(this.name);
		printerField.setType(propertyDescriptor.getPropertyType());
		printerField.setPrinterPropertyDescriptor(propertyDescriptor);
		return printerField;
	}

}
