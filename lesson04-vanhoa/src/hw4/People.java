package hw4;

public abstract class People {
	private String name;
	private int birthYear;
	private double salary;
	
	public People() {
	}

	public People(String name, int birthYear, double salary) {
		this.name = name;
		this.birthYear = birthYear;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", birthYear=" + birthYear + ", salary=" + salary + "]";
	}
	
	public abstract double totalSalary();
	
}
