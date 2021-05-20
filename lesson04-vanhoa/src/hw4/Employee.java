package hw4;

public class Employee extends People {
	private String department;

	public Employee() {
	}

	public Employee(String name, int birthYear, double salary, String department) {
		super(name, birthYear, salary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-15s%20s%25s", getName(), getBirthYear(), "Employee", totalSalary());
	}

	@Override
	public double totalSalary() {
		return this.getSalary() * 1250000;
	}

}
