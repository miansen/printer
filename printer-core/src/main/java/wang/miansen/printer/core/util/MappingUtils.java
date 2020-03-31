package wang.miansen.printer.core.util;

import java.lang.reflect.Proxy;
import java.util.Objects;

import wang.miansen.printer.core.MappingException;

/**
 * 映射工具类
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public abstract class MappingUtils {

	/**
	 * 将一个异常包装成 MappingException 类型的异常，然后抛出
	 * <p>注意：如果异常的类型为 RuntimeException，则不会被包装
	 * 
	 * @param e 源异常
	 * @throws MappingException
	 */
	public static void throwMappingException(Throwable e) throws MappingException {
		if (e instanceof MappingException) {
			throw (MappingException) e;
		} else if (e instanceof RuntimeException) {
			throw (RuntimeException) e;
		} else {
			throw new MappingException(e);
		}
	}

	/**
	 * 抛出 MappingException 类型的异常
	 * 
	 * @param msg 异常的详细信息
	 * @throws MappingException
	 */
	public static void throwMappingException(String msg) throws MappingException {
		throw new MappingException(msg);
	}

	/**
	 * 抛出 MappingException 类型的异常
	 * 
	 * @param msg 异常的详细信息
	 * @param cause 产生异常的根本原因
	 * @throws MappingException
	 */
	public static void throwMappingException(String msg, Throwable cause) throws MappingException {
		throw new MappingException(msg, cause);
	}

	/**
	 * 判断是否为深度映射
	 * 
	 * @param fieldName 字段的名字
	 * @return boolean
	 */
	public static boolean isDeepMapping(String fieldName) {
		return fieldName != null && fieldName.contains(PrinterConstants.DEEP_FIELD_DELIMITER);
	}
	
	/**
	 * 映射是应该被过滤的字段
	 * 
	 * @param fieldName 字段的名称
	 * @param sourceClass 来源类
	 * @param targetClass 目标类
	 * @return 返回 true 的话说明该字段应该被过滤
	 */
	public static boolean shouldIgnoreField(String fieldName, Class<?> sourceClass, Class<?> targetClass) {
		if (Objects.equals("class", fieldName)) {
			return true;
		}
		if ((Objects.equals("callback", fieldName) || Objects.equals("callbacks", fieldName)) 
				&& (isProxy(targetClass) || isProxy(targetClass))) {
			return true;
		}
		return false;
	}
	
	/**
	 * 判断一个对象是否为代理对象
	 * 
	 * @param clazz
	 * @return
	 */
	public static boolean isProxy(Class<?> clazz) {
		if (clazz.isInterface()) {
			return false;
		}
		String className = clazz.getName();
		return Proxy.isProxyClass(clazz) 
				|| (className != null && className.contains(PrinterConstants.CGLIB_CLASS_SEPARATOR));
	}

}
