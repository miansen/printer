package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public interface Converter {

	<T> T doConvert(Class<T> targetClass, Object sourceObj, ConverterChain chain) throws ConvertingException;
	
}
