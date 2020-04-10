package wang.miansen.printer.core.util;

/**
 * 转换工具类
 * 
 * @author miansen.wang
 * @date 2020-04-10
 */
public class ConvertUtils {

	/**
	 * 输入一个基本类型，返回它关联的包装类型。
	 * 
	 * @param type 基本类型
	 * @return 如果输入的是基本类型，则返回它关联的包装类型。如果不是，则返回原本的类型。
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> primitiveToWrapper(final Class<T> type) {
		if (type == null || !type.isPrimitive()) {
			return type;
		}
		if (type == Integer.TYPE) {
			return (Class<T>) Integer.class;
		} else if (type == Double.TYPE) {
			return (Class<T>) Double.class;
		} else if (type == Long.TYPE) {
			return (Class<T>) Long.class;
		} else if (type == Float.TYPE) {
			return (Class<T>) Float.class;
		} else if (type == Short.TYPE) {
			return (Class<T>) Short.class;
		} else if (type == Character.TYPE) {
			return (Class<T>) Character.class;
		} else if (type == Byte.TYPE) {
			return (Class<T>) Byte.class;
		} else if (type == Boolean.class) {
			return (Class<T>) Boolean.class;
		} else {
			return type;
		}
	}

}
