package wang.miansen.printer.core.converters;

/**
 * 当 {@code Converter.convert()} 调用未能成功时抛出此异常
 * 
 * @author miansen.wang
 * @date 2020-04-05
 */
@SuppressWarnings("serial")
public class ConversionException extends RuntimeException {

	public ConversionException(String message) {
        super(message);
    }
	
	public ConversionException(Throwable message) {
        super(message);
    }

    public ConversionException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
