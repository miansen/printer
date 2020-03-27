package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.map.ClassMap;

/**
 * 映射上下文
 * 
 * @author miansen.wang
 * @date 2020-03-21
 */
public class MappingContext {

	/**
	 * 全局的映射配置
	 */
	private Configuration globalConfiguration;

	private List<ClassMap> classMaps = new ArrayList<>();

	public Configuration getGlobalConfiguration() {
		return globalConfiguration;
	}

	public void setGlobalConfiguration(Configuration globalConfiguration) {
		this.globalConfiguration = globalConfiguration;
	}

	public List<ClassMap> getClassMaps() {
		return classMaps;
	}

	public void addClassMap(ClassMap classMap) {
		this.classMaps.add(classMap);
	}

	@Override
	public String toString() {
		return "MappingContext [classMaps=" + classMaps + "]";
	}

}
