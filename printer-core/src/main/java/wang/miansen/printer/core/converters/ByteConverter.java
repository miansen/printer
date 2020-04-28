package wang.miansen.printer.core.converters;

/**
 * 处理与 <b>java.lang.Byte</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class ByteConverter extends NumberConverter {

	public ByteConverter() {
		super();
	}

	public ByteConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return Byte.class;
	}
	
}
