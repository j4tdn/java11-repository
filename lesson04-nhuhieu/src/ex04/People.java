package ex04;

public class People {
	private String name;
	private String yearOfBirth;
	private float coefficientSalary;
	
	public People() {
	}

	public People(String name, String yearOfBirth, float coefficientSalary) {
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.coefficientSalary = coefficientSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
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
		return "People [name=" + name + ", yearOfBirth=" + yearOfBirth + ", coefficientSalary=" + coefficientSalary
				+ "]";
	}


	}
	

