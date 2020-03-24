package wang.miansen.printer.core.metadata;

import wang.miansen.printer.core.propertydescriptor.PrinterPropertyDescriptor;
import wang.miansen.printer.core.propertydescriptor.PropertyDescriptorFactory;

/**
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

	public PrinterFieldBuilder(Class<?> clazz, String name, PropertyDescriptorFactory propertyDescriptorFactory) {
		this.clazz = clazz;
		this.name = name;
		this.propertyDescriptorFactory = propertyDescriptorFactory;
	}

	public PrinterField build() {
		PrinterField printerField = new PrinterField();
		printerField.setClazz(this.clazz);
		printerField.setName(this.name);
		PrinterPropertyDescriptor propertyDescriptor = this.propertyDescriptorFactory.getPropertyDescriptor(clazz, name);
		printerField.setType(propertyDescriptor.getPropertyType());
		printerField.setPrinterPropertyDescriptor(propertyDescriptor);
		return printerField;
	}

}
