package wang.miansen.printer.core;

import wang.miansen.printer.core.util.PrinterConstants;

/**
 * Printer 配置类
 * 
 * @author miansen.wang
 * @date 2020-03-20
 */
public class Configuration {

	/**
	 * 是否开启隐射映射，默认值为 true
	 * <p>如果为 true，则说明开启了隐射映射，相同名字的字段将会被默认映射， 除非手动指定映射规则。
	 */
	private boolean wildcard = PrinterConstants.DEFAULT_WILDCARD;

	/**
	 * 产生异常时是否停止映射，默认是 true
	 * <ul>
	 * 	<li>true: 产生异常时立即停止映射，并抛出异常信息</li>
	 * 	<li>false: 产生异常时跳过并继续下一步映射</li>
	 * </ul>
	 */
	private boolean stopOnErrors = PrinterConstants.DEFAULT_STOP_ON_ERRORS;

	/**
	 * 是否映射 null 字段，默认是 true
	 */
	private boolean mapNull = PrinterConstants.DEFAULT_MAP_NULL;

	/**
	 * 是否映射空字符串，默认是 true
	 */
	private boolean mapEmptyString = PrinterConstants.DEFAULT_MAP_EMPTY_STRING;

	/**
	 * 是否为引用拷贝，默认是 false
	 * <p>如果为 true 的话，Object 类型的字段将会拷贝引用，类似于浅拷贝
	 * <p>如果为 false 的话，Object 类型的字段将会递归创建一个新对象，类似于深拷贝
	 */
	private boolean copyByReferences = PrinterConstants.DEFAULT_COPY_BY_REFERENCES;

	/**
	 * 时间格式化的格式，默认是 "yyyy-MM-dd HH:mm:ss"
	 */
	private String dateFormat = PrinterConstants.DEFAULT_DATE_FORMAT;

	public boolean getWildcard() {
		return wildcard;
	}

	public void setWildcard(boolean wildcard) {
		this.wildcard = wildcard;
	}

	public boolean getStopOnErrors() {
		return stopOnErrors;
	}

	public void setStopOnErrors(boolean stopOnErrors) {
		this.stopOnErrors = stopOnErrors;
	}

	public boolean getMapNull() {
		return mapNull;
	}

	public void setMapNull(boolean mapNull) {
		this.mapNull = mapNull;
	}

	public boolean getMapEmptyString() {
		return mapEmptyString;
	}

	public void setMapEmptyString(boolean mapEmptyString) {
		this.mapEmptyString = mapEmptyString;
	}

	public boolean getCopyByReferences() {
		return copyByReferences;
	}

	public void setCopyByReferences(boolean copyByReferences) {
		this.copyByReferences = copyByReferences;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	@Override
	public String toString() {
		return "Configuration {wildcard=" + wildcard + ", stopOnErrors=" + stopOnErrors + ", mapNull=" + mapNull
				+ ", mapEmptyString=" + mapEmptyString + ", copyByReferences=" + copyByReferences + ", dateFormat="
				+ dateFormat + "}";
	}

}
