package wang.miansen.printer.core.converters;

import java.math.BigDecimal;

/**
 * 处理与 <b>java.math.BigDecimal</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class BigDecimalConverter extends NumberConverter {

	public BigDecimalConverter() {
		super();
	}

	public BigDecimalConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return BigDecimal.class;
	}
	
}
