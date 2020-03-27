package wang.miansen.printer.core.beans;

import wang.miansen.printer.core.util.MappingUtils;

/**
 * 负责确定应使用哪个属性描述符的内部工厂
 * 
 * @author miansen.wang
 * @date 2020-03-24
 */
public final class PrinterPropertyDescriptorFactory {

	/**
	 * 根据输入参数，返回一个合适的属性描述符
	 * 
	 * @return 属性描述符 {@link PrinterPropertyDescriptor} 的具体实现
	 */
	public PrinterPropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
		JavaBeanPropertyDescriptor javaBeanPropertyDescriptor = new JavaBeanPropertyDescriptor(clazz, propertyName);
		// 如果字段的名字符合深度映射的规则，那么提前将 deepPropertyDescriptor 属性初始化
		if (MappingUtils.isDeepMapping(propertyName)) {
			javaBeanPropertyDescriptor.getDeepPropertyDescriptor();
		}
		return javaBeanPropertyDescriptor;
	}

}
