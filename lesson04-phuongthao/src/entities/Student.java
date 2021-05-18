package entities;

public class Student {
	private int MSSV;
	private String name;
	private float theoreticalScore;
	private float practiceScore;
	private float mediumScore;

	public Student() {
		this.name = "";

	}

	public Student(int mSSV, String name, float theoreticalScore, float practiceScore) {
		super();
		this.MSSV = mSSV;
		this.name = name;
		this.theoreticalScore = theoreticalScore;
		this.practiceScore = practiceScore;
		this.mediumScore = getmediumScore();
	}

	public int getMSSV() {
		return MSSV;
	}

	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float gettheoreticalScore() {
		return theoreticalScore;
	}

	public void settheoreticalScore(float theoreticalScore) {
		this.theoreticalScore = theoreticalScore;
	}

	public float getpracticeScore() {
		return practiceScore;
	}

	public void setpracticeScore(float practiceScore) {
		this.practiceScore = practiceScore;
	}

	public float getmediumScore() {
		return (practiceScore + theoreticalScore) / 2;
	}

	@Override
	public String toString() {
		return String.format("%-20s %-20s %-20.2f %-20.2f %-20.2f", MSSV, name, theoreticalScore, practiceScore,
				getmediumScore());
	}

}
