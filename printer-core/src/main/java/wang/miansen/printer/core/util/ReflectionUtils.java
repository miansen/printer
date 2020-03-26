package wang.miansen.printer.core.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 反射工具类
 * 
 * @author miansen.wang
 * @date 2020-03-20
 */
public abstract class ReflectionUtils {

	private static final Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);

	/**
	 * 获取直接父类的泛型的 Class 对象
	 * <p>注意：如果获取不到将返回 {@code Object.class}
	 * 
	 * @param clazz 指定要获取的 Class 对象
	 * @param index 泛型所在位置
	 * @return 返回直接父类的泛型的 Class 对象，如果获取不到将返回 {@code Object.class}
	 */
	public static Class<?> getSuperClassGenericType(final Class<?> clazz, int index) {
		// 获取直接继承的父类（包含泛型参数）
		Type genType = clazz.getGenericSuperclass();
		if (!(genType instanceof ParameterizedType)) {
			logger.warn(String.format("Warn: %s's superclass not ParameterizedType", clazz.getSimpleName()));
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index > params.length || index < 0) {
			logger.warn(String.format("Warn: Index: %s, Size of %s's Parameterized Type: %s .", index,
					clazz.getSimpleName(), params.length));
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(String.format("Warn: %s not set the actual class on superclass generic parameter",
					clazz.getSimpleName()));
			return Object.class;
		}
		return (Class<?>) params[index];
	}

	/**
	 * 获取指定类的所有字段
	 * <p>此方法会过滤掉被 static 修饰的字段和被 Transient 修饰的字段
	 * 
	 * @param clazz 指定要获取的 Class 对象
	 * @return 返回字段的 List 集合
	 */
	public static List<Field> getFieldList(Class<?> clazz) {
		if (Objects.isNull(clazz) || Object.class.equals(clazz)) {
			return Collections.emptyList();
		}
		// 如果 class 是代理对象，则需要获取原来的 class
		/*
		 * if (AopUtils.isAopProxy(clazz) || AopUtils.isJdkDynamicProxy(clazz) || AopUtils.isCglibProxy(clazz)) { clazz
		 * = AopUtils.getTargetClass(clazz); }
		 */
		return Stream.of(clazz.getDeclaredFields()).filter(field -> {
			// 排除被 static 修饰的字段（Field 的 getModifiers() 方法返回 int 类型值表示该字段的修饰符）
			return !Modifier.isStatic(field.getModifiers());
		}).filter(field -> {
			// 排除被 Transient 修饰的字段
			return !Modifier.isTransient(field.getModifiers());
		}).collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * 获取指定字段的 set 方法
	 * 
	 * @param fieldName 指定的字段名
	 * @param clazz 字段所属的类
	 * @return Method
	 * @throws ReflectionException
	 */
	public static Method getWriteMethod(String fieldName, Class<?> clazz) throws RuntimeException {
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, clazz);
			return propertyDescriptor.getWriteMethod();
		} catch (IntrospectionException e) {
			throw new RuntimeException("Could not get write method", e);
		}
	}

	/**
	 * 获取指定字段的 get 方法
	 * 
	 * @param fieldName 指定的字段名
	 * @param clazz 字段所属的类
	 * @return Method
	 * @throws ReflectionException
	 */
	public static Method getReadMethod(String fieldName, Class<?> clazz) throws RuntimeException {
		try {
			PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, clazz);
			return propertyDescriptor.getReadMethod();
		} catch (IntrospectionException e) {
			throw new RuntimeException("Could not get read method", e);
		}
	}

	/**
	 * 假如一个对象符合 Java Bean 定义的规范，则可以根据表达式返回一个值。支持 <b>"."</b> 操作符。使用例子如下：
	 * <code>
	 * 	<pre>
	 * class Foo {
	 * 	Boo boo;
	 * 	public Boo getBoo() {
	 * 		return boo;
	 * 	}
	 * 	public void setBooe(Boo boo) {
	 * 		this.boo = boo;
	 * 	}
	 * }
	 * class Boo {
	 * 	String name;
	 * 	public String getName() {
	 * 		return name;
	 * 	}
	 * 	public void setName(String name) {
	 * 		this.name = name;
	 * 	}
	 * }
	 * public static void main(String[] args) {
	 * 
	 * 	Boo boo = new Boo();
	 * 	boo.setName("hello!");
	 *  
	 * 	Foo foo = new Foo();
	 * 	foo.setBoo(boo);
	 * 
	 * 	// return "hello!"
	 * 	Object result = doExpression("boo.name", foo);
	 * }
	 * 	</pre>
	 * </code>
	 * 
	 * @param expression 表达式，支持 <b>"."</b> 操作符
	 * @param object 符合 Java Bean 定义的规范的对象
	 * @return Object
	 * @throws Exception
	 */
	public static Object doExpression(String expression, Object object) throws Exception {
		if (object == null) {
			return object;
		}
		Object value = null;
		Object next = object;
		String[] segments = expression.split("\\.");
		if (segments.length == 1) {
			Method readMethod = getReadMethod(segments[0], next.getClass());
			value = readMethod.invoke(object);
		} else {
			for (int i = 0; i < segments.length - 1; i++) {
				Method readMethod = getReadMethod(segments[i], next.getClass());
				next = readMethod.invoke(next);
				value = doExpression(segments[i + 1], next);
			}
		}
		return value;
	}

	/**
	 * 执行某个方法
	 * 
	 * @param method 方法描述对象
	 * @param obj 方法所属的目标对象
	 * @param args 方法的参数
	 * @return Object
	 */
	public static Object invoke(Method method, Object obj, Object[] args) {
		Object result = null;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (IllegalAccessException e) {
			MappingUtils.throwMappingException(e);
		} catch (IllegalArgumentException e) {
			MappingUtils.throwMappingException(e);
		} catch (InvocationTargetException e) {
			MappingUtils.throwMappingException(e);
		}
		return result;
	}

	/**
	 * 获取 PropertyDescriptor，支持深度匹配
	 * 
	 * @param clazz 类的 Class 对象
	 * @param fieldName 字段的名字，支持 <b>"."</b> 操作符
	 * @return
	 */
	public static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String fieldName) {
		PropertyDescriptor propertyDescriptor = null;
		if (MappingUtils.isDeepMapping(fieldName)) {
			PropertyDescriptor[] propertyDescriptors = getDeepPropertyDescriptor(clazz, fieldName);
			propertyDescriptor = propertyDescriptors[propertyDescriptors.length - 1];
		} else {
			try {
				propertyDescriptor = new PropertyDescriptor(fieldName, clazz);
			} catch (IntrospectionException e) {
				MappingUtils.throwMappingException(e);
			}
		}
		return propertyDescriptor;
	}

	/**
	 * 深度匹配所有的 PropertyDescriptor
	 * 
	 * @param parentClass 第一个 Class 对象
	 * @param fieldName 字段的名字，必须要有 <b>"."</b> 操作符
	 * @return
	 */
	public static PropertyDescriptor[] getDeepPropertyDescriptor(Class<?> parentClass, String fieldName) {
		if (!MappingUtils.isDeepMapping(fieldName)) {
			MappingUtils.throwMappingException("Field does not contain deep field delimitor");
		}
		StringTokenizer tokens = new StringTokenizer(fieldName, PrinterConstants.DEEP_FIELD_DELIMITER);
		PropertyDescriptor[] propertyDescriptors = new PropertyDescriptor[tokens.countTokens()];
		Class<?> latestClass = parentClass;
		int index = 0;
		while (tokens.hasMoreTokens()) {
			String theFieldName = tokens.nextToken();
			PropertyDescriptor propertyDescriptor = getPropertyDescriptor(latestClass, theFieldName);
			if (propertyDescriptor == null) {
				MappingUtils.throwMappingException("Exception occurred determining deep field hierarchy for Class --> "
						+ parentClass.getName() + ", Field --> " + fieldName + ".  Unable to determine property descriptor for Class --> " 
						+ latestClass.getName() + ", Field Name: " + theFieldName);
			}
			latestClass = propertyDescriptor.getPropertyType();
			propertyDescriptors[index++] = propertyDescriptor;
		}
		return propertyDescriptors;
	}
	
}
