package ex01;

public class Student {
	private int id;
	private String name;
	private Classification classification;
	
	public Student() {
	}

	public Student(int id, String name, Classification classification) {
		super();
		this.id = id;
		this.name = name;
		this.classification = classification;
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

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", classification=" + classification + "]";
	}
	 
	
}
