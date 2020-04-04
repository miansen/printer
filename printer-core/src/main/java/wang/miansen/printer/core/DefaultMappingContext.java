package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import wang.miansen.printer.core.map.ClassMap;

/**
 * 映射上下文
 * <p>在处理 Bean 到 Bean 的映射时，这个接口的实现被传递给映射器 {@link #Mapper} 的实现类对象，
 * 映射器将根据此上下文对象来工作。
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class DefaultMappingContext implements MappingContext {

	/**
	 * 全局的映射配置
	 */
	private Configuration globalConfiguration;

	private Map<String, ClassMap> classMaps;

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#addGlobalConfiguration(wang.miansen.printer.core.Configuration)
	 */
	@Override
	public void addGlobalConfiguration(Configuration globalConfiguration) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#getGlobalConfiguration()
	 */
	@Override
	public Configuration getGlobalConfiguration() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#addClassMap(wang.miansen.printer.core.map.ClassMap)
	 */
	@Override
	public void addClassMap(ClassMap classMap) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#addClassMaps(wang.miansen.printer.core.map.ClassMap[])
	 */
	@Override
	public void addClassMaps(ClassMap[] classMaps) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#getClassMap(java.lang.String)
	 */
	@Override
	public ClassMap getClassMap(String mapId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#getClassMap(java.lang.Class, java.lang.Class)
	 */
	@Override
	public ClassMap getClassMap(Class<?> source, Class<?> target) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#removeClassMap(java.lang.String)
	 */
	@Override
	public void removeClassMap(String mapId) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#removeClassMap(java.lang.Class, java.lang.Class)
	 */
	@Override
	public void removeClassMap(Class<?> source, Class<?> target) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#hasClassMap(java.lang.String)
	 */
	@Override
	public boolean hasClassMap(String mapId) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see wang.miansen.printer.core.IMappingContext#hasClassMap(java.lang.Class, java.lang.Class)
	 */
	@Override
	public boolean hasClassMap(Class<?> source, Class<?> target) {
		// TODO Auto-generated method stub
		return false;
	}


}
