package wang.miansen.printer.core.metadata;

import java.lang.reflect.Method;

/**
 * 字段描述类
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
	private Class<?> type;

	/**
	 * 字段是否可读可写
	 */
	private Boolean accessible;
	
	/**
	 * 字段的读方法
	 */
	private Method readMethod;
	
	/**
	 * 字段的写方法
	 */
	private Method writeMethod;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

	public Boolean getAccessible() {
		return accessible;
	}

	public void setAccessible(Boolean accessible) {
		this.accessible = accessible;
	}

	public Method getReadMethod() {
		return readMethod;
	}

	public void setReadMethod(Method readMethod) {
		this.readMethod = readMethod;
	}

	public Method getWriteMethod() {
		return writeMethod;
	}

	public void setWriteMethod(Method writeMethod) {
		this.writeMethod = writeMethod;
	}

	@Override
	public String toString() {
		return "PrinterField {name=" + name + ", type=" + type + ", accessible=" + accessible + ", readMethod="
				+ readMethod + ", writeMethod=" + writeMethod + "}";
	}

}
