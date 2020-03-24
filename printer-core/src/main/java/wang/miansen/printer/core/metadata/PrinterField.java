package wang.miansen.printer.core.metadata;

/**
 * Printer 内部的字段描述类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterField {

	/**
	 * 字段的名字
	 */
	private String name;

	/**
	 * 字段的类型
	 */
	private Class<?> clazz;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "PrinterField=" + clazz;
	}

}
