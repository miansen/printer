package wang.miansen.printer.core.beans;

import java.beans.PropertyDescriptor;
import java.util.Set;

/**
 * 在内省期间用于查询和设置属性描述符的上下文接口。
 * <p>在处理符合 Java Bean 规范的类时，这个接口的实现被传递给 {@link PrinterIntrospector} 
 * 对象，允许 {@link PrinterIntrospector} 对象为它检测到的属性提供描述符。
 * 
 * @author miansen.wang
 * @date 2020-03-28
 */
public interface IntrospectionContext {

	/**
	 * 获取当前内省的类
	 * 
	 * @return 当前内省的类
	 */
	Class<?> getTargetClass();

	/**
	 * 将给定的属性描述符添加到此上下文。
	 * <p>{@link PrinterIntrospector} 对象在对每个检测到的属性进行内省时会调用此方法。 
	 * 如果此上下文已包含受影响属性的描述符，则将其覆盖。
	 * 
	 * @param descriptor 属性描述符
	 */
	void addPropertyDescriptor(PropertyDescriptor descriptor);

	/**
	 * 向此上下文添加属性描述符数组。 使用此方法，可以一次添加多个描述符。
	 * 
	 * @param descriptors 要添加的属性描述符数组
	 */
	void addPropertyDescriptors(PropertyDescriptor[] descriptors);

	/**
	 * 检测此上下文中是否已经包含指定名称的属性描述符。可以使用此方法来防止已存在的属性描述符被覆盖。
	 * 
	 * @param name 要检测的属性名称
	 * @return 如果已经添加过了此属性的描述符，则返回 {@code true}，否则返回 {@code false}。
	 */
	boolean hasProperty(String name);

	/**
	 * 返回指定名称的属性描述符，如果此属性未知，则返回 <b>null</b>。
	 * 
	 * @param name 属性的名称
	 * @return 属性的描述符；如果此属性未知，则为 <b>null</b>。
	 */
	PropertyDescriptor getPropertyDescriptor(String name);

	/**
	 * 删除指定名称的属性描述符。
	 * 
	 * @param name 属性的名称
	 */
	void removePropertyDescriptor(String name);

	/**
	 * 返回此上下文已知的所有属性的名称的集合。
	 * 
	 * @return 属性名称的集合
	 */
	Set<String> propertyNames();

}
