package wang.miansen.printer.core;

import wang.miansen.printer.core.builder.FieldMapBuilderDirector;

/**
 * 字段基本的映射选项
 * 
 * @author miansen.wang
 * @date 2020-03-26
 */
public final class FieldMappingOptions {

	private FieldMappingOptions() {
		
	}
	
	/**
	 * 产生异常时是否停止映射
	 * <ul>
	 * 	<li>true: 产生异常时立即停止映射，并抛出异常信息</li>
	 * 	<li>false: 产生异常时跳过并继续下一步映射</li>
	 * </ul>
	 */
	public static FieldMappingOption stopOnErrors(final boolean stopOrContinue) {
		return fieldMapBuilder -> {
			if (fieldMapBuilder instanceof FieldMapBuilderDirector.CustomFieldMapBuilder) {
				FieldMapBuilderDirector.CustomFieldMapBuilder customFieldMapBuilder = (FieldMapBuilderDirector.CustomFieldMapBuilder) fieldMapBuilder;
				Configuration fieldConfiguration = customFieldMapBuilder.getFieldConfiguration();
				fieldConfiguration.setStopOnErrors(stopOrContinue);
			}
		};
	}
	
	/**
	 * 是否映射 null 字段
	 */
	public static FieldMappingOption mapNull(final boolean mapNull) {
		return fieldMapBuilder -> {
			if (fieldMapBuilder instanceof FieldMapBuilderDirector.CustomFieldMapBuilder) {
				FieldMapBuilderDirector.CustomFieldMapBuilder customFieldMapBuilder = (FieldMapBuilderDirector.CustomFieldMapBuilder) fieldMapBuilder;
				Configuration fieldConfiguration = customFieldMapBuilder.getFieldConfiguration();
				fieldConfiguration.setMapNull(mapNull);
			}
		};
	}
	
	/**
	 * 是否映射空字符串
	 */
	public static FieldMappingOption mapEmptyString(final boolean mapEmptyString) {
		return fieldMapBuilder -> {
			if (fieldMapBuilder instanceof FieldMapBuilderDirector.CustomFieldMapBuilder) {
				FieldMapBuilderDirector.CustomFieldMapBuilder customFieldMapBuilder = (FieldMapBuilderDirector.CustomFieldMapBuilder) fieldMapBuilder;
				Configuration fieldConfiguration = customFieldMapBuilder.getFieldConfiguration();
				fieldConfiguration.setMapEmptyString(mapEmptyString);
			}
		};
	}
	
	/**
	 * 将字段映射设置为引用拷贝
	 * <p>如果为 true 的话，Object 类型的字段将会拷贝引用，类似于浅拷贝
	 * <p>如果为 false 的话，Object 类型的字段将会递归创建一个新对象，类似于深拷贝
	 */
	public static FieldMappingOption copyByReferences(final boolean copyByReferences) {
		return fieldMapBuilder -> {
			if (fieldMapBuilder instanceof FieldMapBuilderDirector.CustomFieldMapBuilder) {
				FieldMapBuilderDirector.CustomFieldMapBuilder customFieldMapBuilder = (FieldMapBuilderDirector.CustomFieldMapBuilder) fieldMapBuilder;
				Configuration fieldConfiguration = customFieldMapBuilder.getFieldConfiguration();
				fieldConfiguration.setCopyByReferences(copyByReferences);
			}
		};
	}
	
	/**
	 * 设置时间格式化的格式，默认是 "yyyy-MM-dd HH:mm:ss"
	 */
	public static FieldMappingOption dateFormat(final String dateFormat) {
		return fieldMapBuilder -> {
			if (fieldMapBuilder instanceof FieldMapBuilderDirector.CustomFieldMapBuilder) {
				FieldMapBuilderDirector.CustomFieldMapBuilder customFieldMapBuilder = (FieldMapBuilderDirector.CustomFieldMapBuilder) fieldMapBuilder;
				Configuration fieldConfiguration = customFieldMapBuilder.getFieldConfiguration();
				fieldConfiguration.setDateFormat(dateFormat);
			}
		};
	}
	
}
