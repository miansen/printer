package wang.miansen.printer.core.converters;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 处理与 <b>java.util.concurrent.atomic.AtomicInteger</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class AtomicIntegerConverter extends NumberConverter {

	public AtomicIntegerConverter() {
		super();
	}

	public AtomicIntegerConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return AtomicInteger.class;
	}
	
}
