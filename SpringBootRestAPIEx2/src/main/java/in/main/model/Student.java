package in.main.model;

public class Student {
	public Student() {

	}
	public Student(Integer id, String name, Integer age, String course) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.course = course;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	private Integer id;
	private String name;
	private Integer age;
	private String course;

}
