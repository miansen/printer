package wang.miansen.printer.core.propertydescriptor;

/**
 * Printer 内部属性描述符抽象父类，定义了一些公共的属性。
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public abstract class AbstractPropertyDescriptor implements PrinterPropertyDescriptor {
	
	/**
	 * 属性所属的类的类型
	 */
	protected final Class<?> clazz;

	/**
	 * 属性的名字
	 */
    protected final String propertyName;

    /**
     * 带参构造函数，以便能初始化 {@link #propertyType} 和 {@link #propertyName}
     * 
     * @param clazz 属性的类型
     * @param propertyName 属性的名字
     */
	AbstractPropertyDescriptor(Class<?> clazz, String propertyName) {
		this.clazz = clazz;
		this.propertyName = propertyName;
	}
    
}
