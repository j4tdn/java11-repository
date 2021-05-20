package hw1;

public class Student {
	private int id;
	private String name;
	private float trGrade;
	private float prGrade;
	
	public Student() {
	}

	public Student(int id, String name, float trGrade, float prGrade) {
		this.id = id;
		this.name = name;
		this.trGrade = trGrade;
		this.prGrade = prGrade;
	}

	//getter setter
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

	public float getTrGrade() {
		return trGrade;
	}

	public void setTrGrade(float trGrade) {
		this.trGrade = trGrade;
	}

	public float getPrGrade() {
		return prGrade;
	}

	public void setPrGrade(float prGrade) {
		this.prGrade = prGrade;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", trGrade=" + trGrade + ", prGrade=" + prGrade + "]";
	}
	
	public float avgGrade() {
		return (this.prGrade + this.trGrade)/2;
	}
	
}
