package wang.miansen.printer.core.metadata;

/**
 * Printer 内部的 Class 描述类
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterClass {

	/**
	 * Class 的名字
	 */
	private String name;
	
	/**
	 * Class 的类型
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
		return "PrinterClass=" + clazz;
	}

}
