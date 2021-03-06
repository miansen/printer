package wang.miansen.printer.core.metadata;

import java.util.List;

import wang.miansen.printer.core.beans.PrinterPropertyDescriptor;
import wang.miansen.printer.core.beans.PrinterPropertyDescriptorFactory;

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
	private final PrinterClass printerClass;

	/**
	 * 字段的名字
	 */
	private final String name;

	/**
	 * 属性描述符工厂
	 */
	private final PrinterPropertyDescriptorFactory propertyDescriptorFactory;

	/**
	 * 创建一个 {@link PrinterFieldBuilder} 对象
	 * 
	 * @param printerClass 字段所属的类
	 * @param name 字段的名字
	 * @param propertyDescriptorFactory 属性描述符工厂
	 */
	public PrinterFieldBuilder(PrinterClass printerClass, String name, PrinterPropertyDescriptorFactory propertyDescriptorFactory) {
		this.printerClass = printerClass;
		this.name = name;
		this.propertyDescriptorFactory = propertyDescriptorFactory;
	}

	/**
	 * 创建一个 {@link PrinterField} 对象
	 * 
	 * @return
	 */
	public PrinterField build() {
		PrinterPropertyDescriptor propertyDescriptor = propertyDescriptorFactory.getPropertyDescriptor(printerClass.getClazz(), name);
		List<PrinterField> printerFields = printerClass.getPrinterFields();
		PrinterField printerField = new PrinterField();
		printerField.setClazz(printerClass);
		printerField.setName(name);
		printerField.setType(propertyDescriptor.getPropertyType());
		printerField.setPrinterPropertyDescriptor(propertyDescriptor);
		printerFields.add(printerField);
		return printerField;
	}

}
