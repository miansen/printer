package wang.miansen.printer.core.converters;

/**
 * 处理与 <b>java.lang.Short</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class ShortConverter extends NumberConverter {

	public ShortConverter() {
		super();
	}

	public ShortConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return Short.class;
	}
	
}
