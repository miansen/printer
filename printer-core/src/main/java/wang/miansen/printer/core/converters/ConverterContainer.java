package wang.miansen.printer.core.converters;

import wang.miansen.printer.core.Converter;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public interface ConverterContainer {

	void add(Converter<?, ?> converter);
	
	Converter<?, ?> get(Class<? extends Converter<?, ?>> converterClass);
	
}
