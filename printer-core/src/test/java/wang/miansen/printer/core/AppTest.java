package wang.miansen.printer.core;

import org.junit.Test;

import wang.miansen.printer.core.dto.StudentDTO;
import wang.miansen.printer.core.entity.Student;

public class AppTest {
	
	@SuppressWarnings("unused")
	@Test
	public void test01() throws Exception {
		Mapper mapper = PrinterBeanMapperBuilder.create()
								.mapping(Student.class, StudentDTO.class)
								.fields("name", "name")
								.fields("age", "age")
								.ok()
								.mapping(Student.class, StudentDTO.class)
								.fields("addr", "addr")
								.ok()
								.build();
	}
}
