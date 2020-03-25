package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.map.AbstractClassMap;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class MappingContext {

	private List<AbstractClassMap> classMaps = new ArrayList<>();

	public List<AbstractClassMap> getClassMaps() {
		return classMaps;
	}

	public void setClassMaps(List<AbstractClassMap> classMaps) {
		this.classMaps = classMaps;
	}
	
	public void addClassMap(AbstractClassMap classMap) {
		this.classMaps.add(classMap);
	}

	@Override
	public String toString() {
		return "MappingContext [classMaps=" + classMaps + "]";
	}
	
}
