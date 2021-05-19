package ex1;

public class Student {
	private int id;
	private String name;
	private float theorPoint;
	private float practPoint;
	
	
	public Student() {
		this.id = 0;
		this.name = "";
		this.theorPoint = 0;
		this.practPoint = 0;
	}
	
	public Student(int id, String name, float theorPoint, float practPoint) {
		super();
		this.id = id;
		this.name = name;
		this.theorPoint = theorPoint;
		this.practPoint = practPoint;
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

	public float getTheorPoint() {
		return theorPoint;
	}

	public void setTheorPoint(float theorPoint) {
		this.theorPoint = theorPoint;
	}

	public float getPractPoint() {
		return practPoint;
	}

	public void setPractPoint(float practPoint) {
		this.practPoint = practPoint;
	}

	public float averagePoint() {
		return (this.practPoint + this.theorPoint)/2;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", theorPoint=" + theorPoint + ", practPoint=" + practPoint
				+ "]";
	}

	
}
