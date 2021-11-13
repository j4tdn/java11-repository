package bean;

public class Student {
	private String id;
	private String name;
	private double avgPoint;
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
	public double getAvgPoint() {
		return avgPoint;
	}
	public void setAvgPoint(double avgPoint) {
		this.avgPoint = avgPoint;
	}
	public Student(String id, String name, double avgPoint) {
		super();
		this.id = id;
		this.name = name;
		this.avgPoint = avgPoint;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", avgPoint=" + avgPoint + "]";
	}
	
}
