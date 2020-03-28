package wang.miansen.printer.core.beans;

import java.beans.IntrospectionException;

/**
 * 为符合 Java Bean 规范的类执行内省的接口。
 * 
 * @author miansen.wang
 * @date 2020-03-28
 */
public interface PrinterIntrospector {

	/**
	 * 对符合 Java Bean 规范的类执行内省。 可以从传入的 {@link IntrospectionContext} 对象中检查当
	 * 前要内省的类。接口的典型实现必须根据实现的规则确定内省类的属性描述符，并将属性描述符添加到传入的上下文对象中。
	 *  
	 * @param context 与内省请求的发起者进行交互的上下文对象
	 * @throws IntrospectionException 如果内省期间发生错误将抛出此异常
	 */
	void introspect(IntrospectionContext context) throws IntrospectionException;

}
