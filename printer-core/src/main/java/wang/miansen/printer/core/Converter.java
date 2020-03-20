package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public interface Converter<A, B> {

	B convertTo(A source, B destination) throws ConvertingException;
	
	A convertFrom(B source, A destination) throws ConvertingException;
	
}
