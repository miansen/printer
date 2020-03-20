package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
@SuppressWarnings("serial")
public class ConvertingException extends RuntimeException {

	public ConvertingException(String message) {
        super(message);
    }
	
	public ConvertingException(Throwable message) {
        super(message);
    }

    public ConvertingException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
