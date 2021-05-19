package Ex04;

public abstract class Person {
	private String fullName;
	private int yearOfBirth;
	private float coefficientSalary;

	public Person() {
	}

	public Person(String fullName, int yearOfBirth, float coefficientSalary) {
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.coefficientSalary = coefficientSalary;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public float getCoefficientSalary() {
		return coefficientSalary;
	}

	public void setCoefficientSalary(float coefficientSalary) {
		this.coefficientSalary = coefficientSalary;
	}

	@Override
	public String toString() {
		return "Person [fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", coefficientSalary="
				+ coefficientSalary + "]";
	}

	abstract public int calSalary();

}
