package wang.miansen.printer.core.metadata;

/**
 * Printer 内部的 Class 描述类，相当于对 Class 的进一步封装。
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
	 * Class 对象
	 */
	private Class<?> clazz;

	/**
	 * 只能通过 {@link PrinterClassBuilder} 创建实例对象
	 */
	PrinterClass() {

	}

	/**
	 * 获取 Class 的名字
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置 Class 的名字
	 * 
	 * @param name Class 的名字
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取 Class 对象
	 * 
	 * @return Class
	 */
	public Class<?> getClazz() {
		return clazz;
	}

	/**
	 * 设置 Class 对象
	 * 
	 * @param clazz Class 对象
	 */
	void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "PrinterClass=" + clazz;
	}

}
