package wang.miansen.printer.core.entity;

/**
 * @author miansen.wang
 * @date 2020-03-24
 */
public class Dog {

	// 姓名
    private String name;
    
    // 年龄
    private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog {name=" + name + ", age=" + age + "}";
	}
    
}
