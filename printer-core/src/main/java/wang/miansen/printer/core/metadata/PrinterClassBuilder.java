package wang.miansen.printer.core.metadata;

import java.util.ArrayList;

/**
 * 用于创建 {@link PrinterClass} 对象
 * 
 * @author miansen.wang
 * @date 2020-03-25
 */
public class PrinterClassBuilder {

	/**
	 * Class 对象
	 */
	private final Class<?> clazz;

	/**
	 * 创建一个 {@link PrinterClassBuilder} 对象
	 * 
	 * @param clazz Class 对象
	 */
	public PrinterClassBuilder(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 创建一个 {@link PrinterClass} 对象
	 * 
	 * @return PrinterClass
	 */
	public PrinterClass build() {
		PrinterClass printerClass = new PrinterClass();
		printerClass.setClazz(clazz);
		printerClass.setName(clazz.getName());
		printerClass.setPrinterFields(new ArrayList<>());
		return printerClass;
	}

}
