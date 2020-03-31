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
								.field("name", "name", FieldMappingOptions.copyByReferences(true), 
										FieldMappingOptions.mapEmptyString(false))
								.field("age", "age")
								.ok()
								.mapping(Student.class, StudentDTO.class)
								.field("mobile", "mobile")
								.field("dog.name", "name")
								.ok()
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
	
}
