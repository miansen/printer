package wang.miansen.printer.core.propertydescriptor;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import wang.miansen.printer.core.util.MappingUtils;
import wang.miansen.printer.core.util.ReflectionUtils;

/**
 * 用于读取和写入遵循 Java Bean 规范的字段的值
 * 
 * @author miansen.wang
 * @date 2020-03-24
 */
public class JavaBeanPropertyDescriptor extends GetterSetterPropertyDescriptor {

	/**
	 * 属性的类型，如果字段为深度映射，那么表示的是最后一个字段的类型
	 */
	protected Class<?> propertyType;

	/**
	 * 符合 Java Bean 规范的对象的属性描述符，如果字段为深度映射，那么表示的是最后一个字段的属性描述符
	 */
	private PropertyDescriptor propertyDescriptor;

	/**
	 * 符合 Java Bean 规范的对象的属性描述符数组，用于表示深度映射的字段。如果不是深度映射字段，
	 * 那么此属性为 null
	 */
	private PropertyDescriptor[] deepPropertyDescriptor;

	JavaBeanPropertyDescriptor(Class<?> clazz, String propertyName) {
		super(clazz, propertyName);
	}

	@Override
	protected Method getReadMethod() throws NoSuchMethodException {
		return getPropertyDescriptor().getReadMethod();
	}

	@Override
	protected Method getWriteMethod() throws NoSuchMethodException {
		return getPropertyDescriptor().getWriteMethod();
	}

	@Override
	protected Method[] getDeepReadMethod() throws NoSuchMethodException {
		PropertyDescriptor[] deepPropertyDescriptor = getDeepPropertyDescriptor();
		Method[] deepReadMethod = new Method[deepPropertyDescriptor.length];
		int index = 0;
		for (PropertyDescriptor propertyDescriptor : deepPropertyDescriptor) {
			deepReadMethod[index++] = propertyDescriptor.getReadMethod();
		}
		return deepReadMethod;
	}

	@Override
	protected Method[] getDeepWriteMethod() throws NoSuchMethodException {
		PropertyDescriptor[] deepPropertyDescriptor = getDeepPropertyDescriptor();
		Method[] deepWriteMethod = new Method[deepPropertyDescriptor.length];
		int index = 0;
		for (PropertyDescriptor propertyDescriptor : deepPropertyDescriptor) {
			deepWriteMethod[index++] = propertyDescriptor.getWriteMethod();
		}
		return null;
	}

	protected PropertyDescriptor getPropertyDescriptor() {
		if (propertyDescriptor == null) {
			propertyDescriptor = ReflectionUtils.getPropertyDescriptor(clazz, propertyName);
		}
		return propertyDescriptor;
	}

	protected PropertyDescriptor[] getDeepPropertyDescriptor() {
		if (deepPropertyDescriptor == null && MappingUtils.isDeepMapping(propertyName)) {
			deepPropertyDescriptor = ReflectionUtils.getDeepPropertyDescriptor(clazz, propertyName);
		}
		return deepPropertyDescriptor;
	}

	@Override
	public Class<?> getPropertyType() {
		if (propertyType == null) {
			propertyType = getPropertyDescriptor().getPropertyType();
		}
		return propertyType;
	}

}
