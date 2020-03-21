package wang.miansen.printer.core.dto;

/**
 * @author miansen.wang
 * @date 2020-03-21
 */
public class StudentDTO {

	// 身份ID
    private Long id;
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 电话
    private String mobile;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", age=" + age + ", mobile=" + mobile + "]";
	}
	
}
