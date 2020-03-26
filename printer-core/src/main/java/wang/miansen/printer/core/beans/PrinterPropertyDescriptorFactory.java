package wang.miansen.printer.core.beans;

/**
 * 负责确定应使用哪个属性描述符的内部工厂
 * 
 * @author miansen.wang
 * @date 2020-03-24
 */
public final class PrinterPropertyDescriptorFactory {

	/**
	 * 根据输入参数，返回一个合适的属性描述符
	 * @return PrinterPropertyDescriptor
	 */
	public PrinterPropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
		return new JavaBeanPropertyDescriptor(clazz, propertyName);
	}

}
