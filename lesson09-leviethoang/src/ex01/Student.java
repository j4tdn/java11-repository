package ex01;

public class Student {
	private int id;
	private String name;
	private String point;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String point) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return id + "-" + name + "-" + point;
	}
}
