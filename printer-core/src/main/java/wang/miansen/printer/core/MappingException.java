package wang.miansen.printer.core;

/**
 * 映射异常
 * 
 * @author miansen.wang
 * @date 2020-03-20
 */
@SuppressWarnings("serial")
public class MappingException extends RuntimeException {

	public MappingException(String message) {
        super(message);
    }
	
	public MappingException(Throwable message) {
        super(message);
    }

    public MappingException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
