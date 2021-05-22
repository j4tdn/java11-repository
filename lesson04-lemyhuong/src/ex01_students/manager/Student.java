package ex01_students.manager;

public class Student {
	private int id;
	private String name;
	private float theoryScore;
	private float practiceScore;

	public Student() {
		this.id = 0;
		this.name = "";
		this.theoryScore = 0.0f;
		this.practiceScore = 0.0f;
	}

	public Student(int id, String name, float theoryScore, float practiceScore) {
		this.id = id;
		this.name = name;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
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

	public float getTheoryScore() {
		return theoryScore;
	}

	public void setTheoryScore(float theoryScore) {
		this.theoryScore = theoryScore;
	}

	public float getPracticeScore() {
		return practiceScore;
	}

	public void setPracticeScore(float practiceScore) {
		this.practiceScore = practiceScore;
	}
	
	public float avarage() {
		return (this.practiceScore + this.theoryScore)/2;
	}

	@Override
	public String toString() {
		return "Student " + id + "\t" + name + "\t" + theoryScore + "\t\t"
				+ practiceScore + "\t\t"+avarage();
	}
	

}
