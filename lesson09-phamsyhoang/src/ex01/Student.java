package ex01;

public class Student {
	private static String id;
	private static String name;
	private static Grade grade;

	public Student() {

	}

	public Student(String id, String name, Grade grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}

	public static String getId() {
		return id;
	}

	public static void setId(String id) {
		Student.id = id;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		Student.name = name;
	}

	public static Grade getGrade() {
		return grade;
	}

	public static void setGrade(Grade grade) {
		Student.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [id=" + getId() + ", name=" + getName() + ", grade " + getGrade() + "]";
	}

}
