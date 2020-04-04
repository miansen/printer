package wang.miansen.printer.core;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public class PrinterBeanMapper implements Mapper {

	private DefaultMappingContext mappingContext;
	
	PrinterBeanMapper(DefaultMappingContext mappingContext) {
		this.mappingContext = mappingContext;
	}

	public <T> T map(Object source, Class<T> targetClass) throws MappingException {
		return null;
	}

	public void map(Object source, Object target) throws MappingException {

	}

	public <T> T map(Object source, Class<T> targetClass, String mapId) throws MappingException {
		return null;
	}

	public void map(Object source, Object target, String mapId) throws MappingException {

	}

}
