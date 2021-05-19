package Ex04;

public class Director extends Person {
	private float coefficientJob;

	public Director() {
	}

	public Director(String fullName, int yearOfBirth, float coefficientSalary, float coefficientJob) {
		super(fullName, yearOfBirth, coefficientSalary);
		this.coefficientJob = coefficientJob;
	}

	public float getCoefficientJob() {
		return coefficientJob;
	}

	public void setCoefficientJob(float coefficientJob) {
		this.coefficientJob = coefficientJob;
	}

	@Override
	public String toString() {
		return "Director [FullName=" + getFullName() + ", YearOfBirth=" + getYearOfBirth() + ", CoefficientSalary="
				+ getCoefficientSalary() + ", coefficientJob=" + coefficientJob + "]";
	}

	@Override
	public int calSalary() {
		return (int) ((this.getCoefficientJob() + this.getCoefficientJob()) * 3000000);
	}

}
