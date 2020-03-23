package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-23
 */
public interface ConverterChain {

	<T> T doConvert(Class<T> targetClass, Object sourceObj) throws ConvertingException;
	
}
