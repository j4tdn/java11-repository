package bean;

public class Person {
	private String name;
	private String birthYear;
	private float salaryCoeff;

	public Person() {
	}

	public Person(String name, String birthYear, float salaryCoeff) {
		this.name = name;
		this.birthYear = birthYear;
		this.salaryCoeff = salaryCoeff;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

	public float getSalaryCoeff() {
		return salaryCoeff;
	}

	public void setSalaryCoeff(float salaryCoeff) {
		this.salaryCoeff = salaryCoeff;
	}

	@Override
	public String toString() {
		return "People [name = " + name + ", birthYear = " + birthYear + ", salaryCoeff = " + salaryCoeff + "]";
	}

}
