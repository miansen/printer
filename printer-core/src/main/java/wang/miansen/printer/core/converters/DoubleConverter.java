package wang.miansen.printer.core.converters;

/**
 * 处理与 <b>java.lang.Double</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class DoubleConverter extends NumberConverter {

	public DoubleConverter() {
		super();
	}

	public DoubleConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return Double.class;
	}
	
}
