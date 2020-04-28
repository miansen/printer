package wang.miansen.printer.core.converters;

import java.math.BigInteger;

/**
 * 处理与 <b>java.math.BigInteger</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class BigIntegerConverter extends NumberConverter {

	public BigIntegerConverter() {
		super();
	}

	public BigIntegerConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return BigInteger.class;
	}
	
}
