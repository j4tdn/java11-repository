package entities;

public class President extends People {
	private float coeJob;

	public President() {
		super();
	}

	public President(String name, int yearOfBirth, float coeSalary, float coeJob) {
		super(name, yearOfBirth, coeSalary);
		this.coeJob = coeJob;
	}

	public float getCoeJob() {
		return coeJob;
	}

	public void setCoeJob(float coeJob) {
		this.coeJob = coeJob;
	}

	@Override
	float getSalary() {
		return (this.coeJob + this.getCoeSalary()) * 3000000;
	}

	@Override
	public String toString() {
		return String.format("%-20s %-20.2f %-20.2f %20.2f ", "President", coeJob, getCoeSalary(), getSalary());

	}

}
