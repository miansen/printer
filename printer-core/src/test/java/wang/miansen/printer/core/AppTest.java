package wang.miansen.printer.core;

import java.beans.PropertyDescriptor;

import org.junit.Test;

import wang.miansen.printer.core.converters.IntegerConverter;
import wang.miansen.printer.core.dto.StudentDTO;
import wang.miansen.printer.core.entity.Dog;
import wang.miansen.printer.core.entity.Student;
import wang.miansen.printer.core.util.ReflectionUtils;

public class AppTest {
	
	@SuppressWarnings("unused")
	@Test
	public void test01() throws Exception {
		Mapper mapper = PrinterBeanMapperBuilder.create()
								.mapping(Student.class, StudentDTO.class, ClassMappingOptions.wildcard(false))
								.field("dog.name", "name", FieldMappingOptions.copyByReferences(true), 
										FieldMappingOptions.mapEmptyString(false))
								.field("age", "age")
								.ok()
								/*.mapping(Student.class, StudentDTO.class)
								.field("mobile", "mobile")
								.field("dog.name", "name")
								.ok()*/
								.build();
	}
	
	@Test
	public void test02() throws Exception {
		Student student = new Student();
		Dog dog = new Dog();
		dog.setName("wangwang");
		student.setDog(dog);
		PropertyDescriptor propertyDescriptor = ReflectionUtils.getPropertyDescriptor(student.getClass(), "dog.name");
		System.out.println(propertyDescriptor);
	}
	
	@Test
	public void test03() throws Exception {
		Class<Integer> clazz = Integer.class;
		Class clzz2 = int.class;
		Class clazz3 = Integer.TYPE;
		Integer cast = clazz.cast(1);
		Integer cast4 = clazz.cast(1);
		Integer cast5 = clazz.cast(2);
		// int cast3 = (int) clazz3.cast(1);
		// Object cast2 = clzz2.cast(1);
		Class<Dog> dogClass = Dog.class;
		Dog dog1 = new Dog();
		Dog dog2 = dogClass.cast(dog1);
		Dog dog3 = dogClass.cast(null);
		
	}
	
	@Test
	public void test04() throws Exception {
		Dog dog1 = new Dog();
		Object[] strings = new Object[]{"a", 1, dog1};
		Class<? extends Object[]> class1 = strings.getClass();
		Class<?> componentType = class1.getComponentType();
		
		Integer i1 = new Integer(1);
		Integer i2 = new Integer(1);
		Integer i3 = new Integer(1234567);
		
		System.out.println(i1 == i2);
		
		System.out.println(i3.byteValue());
	}
	
	@Test
	public void test05() throws Exception {
		double minValue = Double.MIN_VALUE;
		double maxValue = Double.MAX_VALUE;
		long minValue2 = Long.MIN_VALUE;
		long maxValue2 = Long.MAX_VALUE;
		float f1 = (float) minValue;
		float f2 = (float) maxValue;
		int i1 = (int) minValue2;
		int i2 = (int) maxValue2;
		Float minFloat = new Float(minValue);
		Float maxFloat = new Float(maxValue);
		System.out.println(minValue);
		System.out.println(maxValue);
		System.out.println(minFloat.floatValue());
		System.out.println(maxFloat.floatValue());
		Integer i3 = 0;
		double doubleValue = i3.doubleValue();
		float floatValue = i3.floatValue();
	}
	
	@Test
	public void test06() throws Exception {
		Long long0 = 123L;
		Long long1 = new Long(123L);
		Long long2 = Long.valueOf(123L);
		
		//String string = "abc";
		String string1 = new String("abc");
		String string2 = String.valueOf("abc");
		String string3 = String.valueOf("abc");
		String string4 = "abc";
	}
	
	@Test
	public void test07() throws Exception {
		IntegerConverter integerConverter = new IntegerConverter("123a");
		Object integer = integerConverter.convert("123a", Object.class);
		
	}
	
	@Test
	public void test08() throws Exception {
		System.out.println(Float.POSITIVE_INFINITY + 10000);
		System.out.println(Float.POSITIVE_INFINITY - 10000);
		System.out.println(Float.POSITIVE_INFINITY * 10000);
		System.out.println(Float.POSITIVE_INFINITY / 10000);
		
		System.out.println(Float.NEGATIVE_INFINITY + 10000);
		System.out.println(Float.NEGATIVE_INFINITY - 10000);
		System.out.println(Float.NEGATIVE_INFINITY * 10000);
		System.out.println(Float.NEGATIVE_INFINITY / 10000);
		
		System.out.println(Float.isInfinite(Float.POSITIVE_INFINITY));
		System.out.println(Float.isInfinite(Float.NEGATIVE_INFINITY));
		
		System.out.println(Float.isNaN(Float.NaN)); // output: false
		System.out.println(Double.isNaN(Double.NaN)); // output: true
		
		System.out.println(Float.NaN == Float.NaN);
		System.out.println(Double.NaN == Double.NaN);
	}
	
	@Test
	public void test09() throws Exception {
		
	}
	
}
