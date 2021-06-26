package ex01;

public class Student {
	private int Id;
	private String name;
	private String classification;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name, String classification) {
		super();
		Id = id;
		this.name = name;
		this.classification = classification;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", classification=" + classification + "]";
	}

	
	
	
}
