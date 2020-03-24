package wang.miansen.printer.core.metadata;

/**
 * @author miansen.wang
 * @date 2020-03-24
 */
public class PrinterFieldBuilder {

	/**
	 * 字段的名字
	 */
	private String name;

	/**
	 * 字段的类型
	 */
	private Class<?> clazz;

	public PrinterFieldBuilder(String name, Class<?> clazz) {
		this.name = name;
		this.clazz = clazz;
	}
	
	public PrinterField build() {
		return null;
	}
	
}
