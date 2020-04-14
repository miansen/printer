package wang.miansen.printer.core.converters;

/**
 * 数字转换器
 * 
 * @author miansen.wang
 * @date 2020-04-14
 */
public abstract class NumberConverter extends AbstractConverter {

	@Override
	protected <T> T convertProcess(Object value, Class<T> type) throws ConversionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?> getTargetType() {
		return Number.class;
	}

}
