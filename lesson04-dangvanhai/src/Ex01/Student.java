package Ex01;

public class Student {
	private int idStudent;
	private String fullName;
	private float theoryScore;
	private float practiceScore;

	public Student() {
		this.idStudent = 0;
		this.fullName = "";
		this.theoryScore = 0f;
		this.practiceScore = 0f;
	}

	public Student(int idStudent, String fullName, float theoryScore, float practiceScore) {
		super();
		this.idStudent = idStudent;
		this.fullName = fullName;
		this.theoryScore = theoryScore;
		this.practiceScore = practiceScore;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	@Override
	public String toString() {
		return "Student [idStudent=" + idStudent + ", fullName=" + fullName + ", theoryScore=" + theoryScore
				+ ", practiceScore=" + practiceScore + ", averageScore=" + this.getAverageScore() + "]";
	}

	/**
	 * 
	 * @return a float number with one decimal points, its average of the theory and
	 *         practice score
	 */
	public float getAverageScore() {
		return (float) Math.round((this.theoryScore + this.practiceScore) / 2 * 10) / 10;
	}

}
