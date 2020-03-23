package wang.miansen.printer.core.propertydescriptor;

import java.lang.reflect.Method;

import wang.miansen.printer.core.util.MappingUtils;
import wang.miansen.printer.core.util.ReflectionUtils;

/**
 * 用于读取和写入具有 getter 和 setter 方法的字段的值
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public abstract class GetterSetterPropertyDescriptor extends AbstractPropertyDescriptor {

	public GetterSetterPropertyDescriptor(Class<?> propertyType, String propertyName) {
		super(propertyType, propertyName);
	}

	/**
	 * 获取字段的 getter 方法
	 * 
	 * @return Method
	 * @throws NoSuchMethodException
	 */
	protected abstract Method getReadMethod() throws NoSuchMethodException;
	
	/**
	 * 获取字段的 setter 方法
	 * 
	 * @return Method
	 * @throws NoSuchMethodException
	 */
	protected abstract Method getWriteMethod() throws NoSuchMethodException;

	/**
	 * 获取 setter 方法的参数类型
	 * 
	 * @return Class
	 */
	protected Class<?> getWriteMethodParameterType() {
		try {
			return getWriteMethod().getParameterTypes()[0];
		} catch (Exception e) {
			MappingUtils.throwMappingException(e);
			return null;
		}
	}

	/**
	 * 获取属性的值
	 * 
	 * @param bean 目标对象
	 * @return Object
	 */
	protected Object getPropertyValue(Object bean) {
		Object result = null;
		// 看看是否为深度映射
		if (MappingUtils.isDeepMapping(propertyName)) {
			result = getDeepPropertyValue(bean);
		} else {
			result = invokeReadMethod(bean);
		}
		return result;
	}

	/**
	 * 设置属性的值
	 * 
	 * @param bean 目标对象
	 * @param value 要设置的值
	 */
	protected void setPropertyValue(Object bean, Object value) {
		// 看看是否为深度映射
		if (MappingUtils.isDeepMapping(propertyName)) {
			setDeepPropertyValue(bean, value);
		} else {
			invokeWriteMethod(bean, value);
		}
	}

	/**
	 * 执行 getter 方法
	 * 
	 * @param obj 目标对象
	 * @return Object
	 */
	protected Object invokeReadMethod(Object bean) {
		Object result = null;
		try {
			result = ReflectionUtils.invoke(getReadMethod(), bean, null);
		} catch (NoSuchMethodException e) {
			MappingUtils.throwMappingException(e);
		}
		return result;
	}

	/**
	 * 执行 setter 方法
	 * 
	 * @param bean 目标对象
	 * @param value setter 方法的参数
	 */
	protected void invokeWriteMethod(Object bean, Object value) {
		try {
			ReflectionUtils.invoke(getWriteMethod(), bean, new Object[]{value});
		} catch (NoSuchMethodException e) {
			MappingUtils.throwMappingException(e);
		}
	}

	/**
	 * 获取深度映射的属性值
	 * 
	 * @param bean 目标对象
	 * @return Object
	 */
	private Object getDeepPropertyValue(Object bean) {
		return null;
	}

	/**
	 * 设置深度映射的属性值
	 * 
	 * @param bean 目标对象
	 * @param value 要设置的值
	 */
	private void setDeepPropertyValue(Object bean, Object value) {
		// TODO Auto-generated method stub

	}

}
