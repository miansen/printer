package wang.miansen.printer.core.util;

/**
 * 字符串工具类
 * 
 * @author miansen.wang
 * @date 2020-04-23
 */
public abstract class StringUtils {

	/**
	 * 校验字符串是否为空
	 * 
	 * @param str 入参
	 * @return boolean
	 */
	public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
	
}
