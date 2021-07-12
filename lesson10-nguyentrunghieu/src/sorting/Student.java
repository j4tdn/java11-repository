package sorting;

public class Student {
	private String id;
	private String fullName;
	private int age;

	public Student() {
	}

	public Student(String id, String fullName, int age) {
		this.id = id;
		this.fullName = fullName;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int isAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return id + " - " + fullName + " - " + age + " tuổi.";
	}
}
