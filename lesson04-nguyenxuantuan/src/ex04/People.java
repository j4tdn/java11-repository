package ex04;

abstract class People {
	protected String name;
	protected String yearOfBirth;
	protected float coefficientSalary;
	
	abstract float getSalary();
	
	public People() {
	}
	

	public People(String name, String yearOfBirth, float coefficientSalary) {
		super();
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