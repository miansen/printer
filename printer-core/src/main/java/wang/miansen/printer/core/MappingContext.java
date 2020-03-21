package wang.miansen.printer.core;

import java.util.ArrayList;
import java.util.List;

import wang.miansen.printer.core.map.ClassMap;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class MappingContext {

	private List<ClassMap> classMaps = new ArrayList<>();

	public List<ClassMap> getClassMaps() {
		return classMaps;
	}

	public void setClassMaps(List<ClassMap> classMaps) {
		this.classMaps = classMaps;
	}
	
	public void addClassMap(ClassMap classMap) {
		this.classMaps.add(classMap);
	}

	@Override
	public String toString() {
		return "MappingContext [classMaps=" + classMaps + "]";
	}
	
}
