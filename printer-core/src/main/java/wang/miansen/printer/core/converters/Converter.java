package wang.miansen.printer.core.converters;

/**
 * 转换器接口
 * 
 * @author miansen.wang
 * @date 2020-04-05
 * @since 1.0
 */
public interface Converter {

	/**
	 * 将指定的输入对象转换为指定类型的输出对象s
	 * 
	 * @param value 原始值
	 * @param type 要转换的类型
	 * @return 转换值
	 * @throws ConversionException 如果转换发生错误并且默认值为 {@code null}，则抛出此异常。
	 */
	public <T> T convert(Object value, Class<T> type) throws ConversionException;
	
}
