package wang.miansen.printer.core;

import wang.miansen.printer.core.director.ClassMapBuildDirector;
import wang.miansen.printer.core.map.ClassMap;

/**
 * @author miansen.wang
 * @date 2020-03-20
 */
public class PrinterBeanMapperBuilder {

	private DefaultMappingContext mappingContext;
	
	private PrinterBeanMapperBuilder() {
		mappingContext = new DefaultMappingContext();
	}

	public static PrinterBeanMapperBuilder create() {
		return new PrinterBeanMapperBuilder();
	}

	public ClassMapBuildDirector mapping(Class<?> source, Class<?> target, ClassMappingOption... classMappingOptions) {
		ClassMapBuildDirector classMapBuildDirector = new ClassMapBuildDirector(source, target, mappingContext, this);
		ClassMapBuildDirector.ClassMapBuilder customClassMapBuilder = classMapBuildDirector.custom();
		for (ClassMappingOption classMappingOption : classMappingOptions) {
			classMappingOption.apply(customClassMapBuilder);
		}
		ClassMap classMap = customClassMapBuilder.build();
		mappingContext.addClassMap(classMap);
		return classMapBuildDirector;
	}

	public PrinterBeanMapper build() {
		return new PrinterBeanMapper(mappingContext);
	}

}
