package wx.th.zlo.javabaseboot.aabase;

public class Student {
	private String name;
	
	private String age;
	
	private String sex;

	public Student() {
		super();
	}

	public Student(String name, String age, String sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public  void greet(){
		System.out.println("hello");
	}

}
