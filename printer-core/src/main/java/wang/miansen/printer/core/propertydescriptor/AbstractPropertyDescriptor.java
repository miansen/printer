package wang.miansen.printer.core.propertydescriptor;

/**
 * Printer 内部属性描述符抽象父类，定义了一些公共的属性。
 * 
 * @author miansen.wang
 * @date 2020-03-23
 */
public abstract class AbstractPropertyDescriptor {

	/**
	 * 属性的类型
	 */
	protected final Class<?> propertyType;
	
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
	public AbstractPropertyDescriptor(Class<?> propertyType, String propertyName) {
		this.propertyType = propertyType;
		this.propertyName = propertyName;
	}
    
}
