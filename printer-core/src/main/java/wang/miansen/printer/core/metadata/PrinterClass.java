package wang.miansen.printer.core.metadata;

/**
 * 用于描述映射类，相当于对 Class 的进一步封装。
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class PrinterClass {

	/**
	 * 映射类的全限定名
	 */
	private String name;

	/**
	 * 映射类的 Class 对象
	 */
	private Class<?> clazz;

	/**
	 * 只能通过 {@link PrinterClassBuilder} 创建实例对象
	 */
	PrinterClass() {

	}

	/**
	 * 获取映射类的全限定名
	 * 
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置映射类的全限定名
	 * 
	 * @param name 类的全限定名
	 */
	void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取映射类的 Class 对象
	 * 
	 * @return Class
	 */
	public Class<?> getClazz() {
		return clazz;
	}

	/**
	 * 设置映射类的 Class 对象
	 * 
	 * @param clazz 映射类的 Class 对象
	 */
	void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		return "PrinterClass=" + name;
	}

}
