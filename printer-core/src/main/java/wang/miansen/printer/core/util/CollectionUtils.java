package wang.miansen.printer.core.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Collection 工具类
 * 
 * @author miansen.wang
 * @date 2020-03-31
 */
public class CollectionUtils {

	/**
	 * 校验集合是否为空
	 *
	 * @param coll 入参
	 * @return boolean
	 */
	public static boolean isEmpty(Collection<?> coll) {
		return (coll == null || coll.isEmpty());
	}

	/**
	 * 校验集合是否不为空
	 *
	 * @param coll 入参
	 * @return boolean
	 */
	public static boolean isNotEmpty(Collection<?> coll) {
		return !isEmpty(coll);
	}

	/**
	 * 判断Map是否为空
	 *
	 * @param map 入参
	 * @return boolean
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	/**
	 * 判断Map是否不为空
	 *
	 * @param map 入参
	 * @return boolean
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return !isEmpty(map);
	}

	/**
	 * 取两个 {@code set} 集合的交集
	 * @param set1 集合1
	 * @param set2 集合2
	 * @return 交集
	 */
	public static <E> Set<E> intersection(final Set<E> set1, final Set<?> set2) {
		Set<E> intersection = new HashSet<E>(set1);
		intersection.retainAll(set2);
		return intersection;
	}
}
