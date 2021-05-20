package bean;

public class Director extends Person {
	private float coefficientJob;

	public Director() {
	}

	public Director(String name, String birthYear, float salaryCoeff, float coefficientJob) {
		super(name, birthYear, salaryCoeff);
		this.coefficientJob = coefficientJob;
	}

	public float getCoefficientJob() {
		return coefficientJob;
	}

	public void setCoefficientJob(float coefficientJob) {
		this.coefficientJob = coefficientJob;
	}

	public float calSalary() {
		return (this.getCoefficientJob() + this.getCoefficientJob()) * 3000000;
	}

	@Override
	public String toString() {
		return "Director [coefficientJob = " + coefficientJob + ", getCoefficientJob = " + getCoefficientJob()
				+ ", calSalary = " + calSalary() + ", getName = " + getName() + ", getBirthYear = " + getBirthYear()
				+ ", getSalaryCoeff = " + getSalaryCoeff() + " ]";
	}

}
