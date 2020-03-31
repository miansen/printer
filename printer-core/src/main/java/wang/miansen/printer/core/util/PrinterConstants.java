package wang.miansen.printer.core.util;

/**
 * Printer 常量池
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public interface PrinterConstants {

	/**
	 * 是否开启隐射映射
	 * <p>如果为 true，则说明开启了隐射映射，相同名字的字段将会被默认映射，
	 * 除非手动指定映射规则。
	 */
	boolean DEFAULT_WILDCARD = true;
	
	/**
	 * 产生异常时是否停止映射
	 * <ul>
	 * 	<li>true: 产生异常时立即停止映射，并抛出异常信息</li>
	 * 	<li>false: 产生异常时跳过并继续下一步映射</li>
	 * </ul>
	 */
	boolean DEFAULT_STOP_ON_ERRORS = true;
	
	/**
	 * 是否映射 null 字段
	 */
	boolean DEFAULT_MAP_NULL = true;
	
	/**
	 * 是否映射空字符串
	 */
	boolean DEFAULT_MAP_EMPTY_STRING = true;
	
	/**
	 * 是否为引用拷贝
	 */
	boolean DEFAULT_COPY_BY_REFERENCES = false;
	
	/**
	 * 时间格式化的格式
	 */
	String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 用于判断是否为深度映射
	 */
	String DEEP_FIELD_DELIMITER = ".";
	
	String CGLIB_CLASS_SEPARATOR = "$$EnhancerByCGLIB$$";  
	
}
