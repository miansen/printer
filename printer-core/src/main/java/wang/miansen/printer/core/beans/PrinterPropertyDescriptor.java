package wang.miansen.printer.core.beans;

/**
 * Printer 内部属性描述符接口。用于读取和写入目标对象上的实际字段映射值。
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public interface PrinterPropertyDescriptor {

	/**
	 * 获取属性的类型
	 * 
	 * @return Class
	 */
	Class<?> getPropertyType();
	
	/**
	 * 获取属性的值
	 * 
	 * @param bean 目标对象
	 * @return Object
	 */
	Object getPropertyValue(Object bean);
	
	/**
	 * 设置属性的值
	 * 
	 * @param bean 目标对象
	 * @param value 属性值
	 */
	void setPropertyValue(Object bean, Object value);
	
}
