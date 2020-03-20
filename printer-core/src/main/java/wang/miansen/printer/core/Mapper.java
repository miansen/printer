package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public interface Mapper {

	<T> T map(Object source, Class<T> targetClass) throws MappingException;
	
	void map(Object source, Object target) throws MappingException;
	
	<T> T map(Object source, Class<T> targetClass, String mapId) throws MappingException;
	
	void map(Object source, Object target, String mapId) throws MappingException;
	
}
