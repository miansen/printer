package wang.miansen.printer.core.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link PrinterIntrospector} 默认的实现。
 * <p>这个类是基于 JDK 提供的 {@link Introspector} 类实现的内省方法。</p>
 * <p>此类没有定义任何状态，所以它被设计成单例的，请使用 {@link #instance()} 方法获取此类的单例实例。</p>
 * 
 * @author miansen.wang
 * @date 2020-03-29
 * @since 1.0
 */
public class JavaBeanIntrospector implements PrinterIntrospector {

	private static final Logger logger = LoggerFactory.getLogger(JavaBeanIntrospector.class);
	
	private static final Object LOCK = new Object();

	/**
	 * 此类的单例实例
	 */
	private static volatile JavaBeanIntrospector javaBeanIntrospector;

	/**
	 * 私有构造函数，因此无法创建任何实例。请通过 {@link #instance()} 方法获取此类的实例。
	 */
	private JavaBeanIntrospector() {

	}

	/**
	 * 获取此类的单例实例
	 * 
	 * @return JavaBeanIntrospector 类的实例
	 */
	public static JavaBeanIntrospector instance() {
		if (javaBeanIntrospector == null) {
			synchronized (LOCK) {
				if (javaBeanIntrospector == null) {
					javaBeanIntrospector = new JavaBeanIntrospector();
				}
			}
		}
		return javaBeanIntrospector;
	}

	/**
	 * 执行符合 Java Bean 规范的类的内省。 此实现使用 {@code java.beans.Introspector.getBeanInfo()} 方法
	 * 获取当前类的所有属性描述符，并将它们添加到传递的内省上下文中。
	 */
	@Override
	public void introspect(IntrospectionContext context) throws IntrospectionException {
		BeanInfo beanInfo = null;
		try {
			beanInfo = Introspector.getBeanInfo(context.getTargetClass());
		} catch (Exception e) {
			logger.error("Error when inspecting class " + context.getTargetClass(), e);
			return;
		}
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		if (descriptors == null) {
			descriptors = new PropertyDescriptor[0];
		}
		context.addPropertyDescriptors(descriptors);
	}

}
