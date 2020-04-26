package wang.miansen.printer.core;

import java.beans.PropertyDescriptor;

import org.junit.Test;

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
	
}
