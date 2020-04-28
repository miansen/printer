package wang.miansen.printer.core.converters;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 处理与 <b>java.util.concurrent.atomic.AtomicLong</b> 对象之间的转换
 * 
 * @author miansen.wang
 * @date 2020-04-27
 * @since 1.0
 */
public final class AtomicLongConverter extends NumberConverter {

	public AtomicLongConverter() {
		super();
	}

	public AtomicLongConverter(Object defaultValue) {
		super(defaultValue);
	}

	@Override
	protected Class<?> getTargetType() {
		return AtomicLong.class;
	}
	
}
