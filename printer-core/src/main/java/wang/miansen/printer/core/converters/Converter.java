package wang.miansen.printer.core.converters;

/**
 * 数据类型转换器接口
 * 
 * @author miansen.wang
 * @date 2020-04-05
 */
public interface Converter {

	/**
	 * 将指定的输入对象转换为指定类型的输出对象
	 * 
	 * @param value 指定的输入对象
	 * @param type 要转换的数据类型
	 * @return 转换值
	 * @throws ConversionException 如果无法成功执行转换将抛出此异常
	 */
	public <T> T convert(Object value, Class<T> type) throws ConversionException;
	
}
