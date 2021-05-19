package ex01;

public class Student {
	
	private int id;
	private String name;
	private float theoryMark, pracMark;
	
	public Student() {
		this.id = 0;
		this.name = "";
		this.theoryMark = 0;
		this.pracMark = 0;
	}
	
	
	public Student(int id, String name, float theoryMark, float pracMark) {
	
		this.id = id;
		this.name = name;
		this.theoryMark = theoryMark;
		this.pracMark = pracMark;
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


	public float getTheoryMark() {
		return theoryMark;
	}


	public void setTheoryMark(float theoryMark) {
		this.theoryMark = theoryMark;
	}


	public float getPracMark() {
		return pracMark;
	}


	public void setPracMark(float pracMark) {
		this.pracMark = pracMark;
	}
	
	


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", theoryMark=" + theoryMark + ", pracMark=" + pracMark + "]";
	}


	public float getMarkAvg() {
		return (this.theoryMark + this.pracMark)/2;
	}
	
}