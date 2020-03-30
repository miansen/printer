package wang.miansen.printer.core.beans;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 在内省期间用于查询和设置属性描述符的上下文接口的默认实现
 * 
 * @author miansen.wang
 * @date 2020-03-29
 * @since 1.0
 */
public class DefaultIntrospectionContext implements IntrospectionContext {

	/**
	 * 执行内省的目标类
	 */
	private final Class<?> targetClass;

	/**
	 * 用于存储已经添加的属性描述符
	 */
	private final Map<String, PropertyDescriptor> descriptors;

	/**
	 * 空的属性描述符数组常量
	 */
	private static final PropertyDescriptor[] EMPTY_DESCRIPTORS = new PropertyDescriptor[0];

	/**
	 * 创建 {@link DefaultIntrospectionContext} 的新实例，并将传入的类设置为将要执行内省的目标类。
	 * 
	 * @param targetClass 要执行内省的类
	 */
	public DefaultIntrospectionContext(Class<?> targetClass) {
		this.targetClass = targetClass;
		this.descriptors = new HashMap<>();
	}

	@Override
	public Class<?> getTargetClass() {
		return targetClass;
	}

	@Override
	public void addPropertyDescriptor(PropertyDescriptor descriptor) {
		if (descriptor == null) {
			throw new IllegalArgumentException("Property descriptor must not be null.");
		}
		descriptors.put(descriptor.getName(), descriptor);
	}

	@Override
	public void addPropertyDescriptors(PropertyDescriptor[] descriptors) {
		if (descriptors == null) {
			throw new IllegalArgumentException("Array with descriptors must not be null.");
		}
		for (PropertyDescriptor descriptor : descriptors) {
			addPropertyDescriptor(descriptor);
		}
	}

	@Override
	public PropertyDescriptor getPropertyDescriptor(String name) {
		return descriptors.get(name);
	}

	@Override
	public PropertyDescriptor[] getPropertyDescriptors() {
		return descriptors.values().toArray(EMPTY_DESCRIPTORS);
	}

	@Override
	public void removePropertyDescriptor(String name) {
		descriptors.remove(name);
	}

	@Override
	public boolean hasProperty(final String name) {
		return descriptors.containsKey(name);
	}

	@Override
	public Set<String> propertyNames() {
		return descriptors.keySet();
	}

}
