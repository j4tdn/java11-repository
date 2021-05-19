package ex4;

public class People {
	private String name;
	private String birthYear;
	private float salaryCoeff;
	public People() {};
	public People(String name, String birthYear, float salaryCoeff) {
		super();
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
		return "People [name=" + name + ", birthYear=" + birthYear + ", salaryCoeff=" + salaryCoeff + "]";
	}
	
}
