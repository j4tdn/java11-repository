package bean;

public class Student {
	private int schoolI;
	private int StudentId;
	private String name;
	private int age;

	public Student() {
	}

	public Student(int id, String name, int age) {
		this.StudentId = id;
		this.name = name;
		this.age = age;
	}

	public Student(int schoolI, int studentId, String name, int age) {
		this.schoolI = schoolI;
		this.StudentId = studentId;
		this.name = name;
		this.age = age;
	}

	public int getSchoolI() {
		return schoolI;
	}

	public void setSchoolI(int schoolI) {
		this.schoolI = schoolI;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int id) {
		this.StudentId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [schoolId=" + schoolI + ", StudentId=" + StudentId + ", name=" + name + ", age=" + age + "]";
	}

}
