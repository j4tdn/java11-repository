package ex01;

public class Student {
	private String id;
	private String name;
	private Classification cf;

	public Student() {
	}

	public Student(String id, String name, Classification cf) {
		super();
		this.id = id;
		this.name = name;
		this.cf = cf;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Classification getCf() {
		return cf;
	}

	public void setCf(Classification cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cf=" + cf + "]";
	}

}
