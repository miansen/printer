package wang.miansen.printer.core;

import wang.miansen.printer.core.director.ClassMapBuildDirector;

/**
 * 类级别的映射选项
 * 
 * @author miansen.wang
 * @date 2020-03-26
 */
public final class ClassMappingOptions {

	private ClassMappingOptions() {
		
	}
	
	/**
	 * 是否开启隐射映射
	 * <p>如果为 true，则说明开启了隐射映射，相同名字的字段将会被默认映射。
	 */
	public static ClassMappingOption wildcard(final boolean wildcard) {
		return classMapBuilder -> {
			if (classMapBuilder instanceof ClassMapBuildDirector.CustomClassMapBuilder) {
				ClassMapBuildDirector.CustomClassMapBuilder customClassMapBuilder = (ClassMapBuildDirector.CustomClassMapBuilder) classMapBuilder;
				Configuration classConfiguration = customClassMapBuilder.getClassConfiguration();
				classConfiguration.setStopOnErrors(wildcard);
			}
		};
	}
	
	/**
	 * 产生异常时是否停止映射
	 * <ul>
	 * 	<li>true: 产生异常时立即停止映射，并抛出异常信息</li>
	 * 	<li>false: 产生异常时跳过并继续下一步映射</li>
	 * </ul>
	 */
	public static ClassMappingOption stopOnErrors(final boolean stopOrContinue) {
		return classMapBuilder -> {
			if (classMapBuilder instanceof ClassMapBuildDirector.CustomClassMapBuilder) {
				ClassMapBuildDirector.CustomClassMapBuilder customClassMapBuilder = (ClassMapBuildDirector.CustomClassMapBuilder) classMapBuilder;
				Configuration classConfiguration = customClassMapBuilder.getClassConfiguration();
				classConfiguration.setStopOnErrors(stopOrContinue);
			}
		};
	}
	
	/**
	 * 是否映射 null 字段
	 */
	public static ClassMappingOption mapNull(final boolean mapNull) {
		return classMapBuilder -> {
			if (classMapBuilder instanceof ClassMapBuildDirector.CustomClassMapBuilder) {
				ClassMapBuildDirector.CustomClassMapBuilder customClassMapBuilder = (ClassMapBuildDirector.CustomClassMapBuilder) classMapBuilder;
				Configuration classConfiguration = customClassMapBuilder.getClassConfiguration();
				classConfiguration.setMapNull(mapNull);
			}
		};
	}
	
	/**
	 * 是否映射空字符串
	 */
	public static ClassMappingOption mapEmptyString(final boolean mapEmptyString) {
		return classMapBuilder -> {
			if (classMapBuilder instanceof ClassMapBuildDirector.CustomClassMapBuilder) {
				ClassMapBuildDirector.CustomClassMapBuilder customClassMapBuilder = (ClassMapBuildDirector.CustomClassMapBuilder) classMapBuilder;
				Configuration classConfiguration = customClassMapBuilder.getClassConfiguration();
				classConfiguration.setMapEmptyString(mapEmptyString);
			}
		};
	}
	
	/**
	 * 将字段映射设置为引用拷贝
	 * <p>如果为 true 的话，Object 类型的字段将会拷贝引用，类似于浅拷贝
	 * <p>如果为 false 的话，Object 类型的字段将会递归创建一个新对象，类似于深拷贝
	 */
	public static ClassMappingOption copyByReferences(final boolean copyByReferences) {
		return classMapBuilder -> {
			if (classMapBuilder instanceof ClassMapBuildDirector.CustomClassMapBuilder) {
				ClassMapBuildDirector.CustomClassMapBuilder customClassMapBuilder = (ClassMapBuildDirector.CustomClassMapBuilder) classMapBuilder;
				Configuration classConfiguration = customClassMapBuilder.getClassConfiguration();
				classConfiguration.setCopyByReferences(copyByReferences);
			}
		};
	}
	
	/**
	 * 设置时间格式化的格式，默认是 "yyyy-MM-dd HH:mm:ss"
	 */
	public static ClassMappingOption dateFormat(final String dateFormat) {
		return classMapBuilder -> {
			if (classMapBuilder instanceof ClassMapBuildDirector.CustomClassMapBuilder) {
				ClassMapBuildDirector.CustomClassMapBuilder customClassMapBuilder = (ClassMapBuildDirector.CustomClassMapBuilder) classMapBuilder;
				Configuration classConfiguration = customClassMapBuilder.getClassConfiguration();
				classConfiguration.setDateFormat(dateFormat);
			}
		};
	}
	
}
