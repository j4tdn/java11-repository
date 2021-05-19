package ex04;

public class Employee extends People{
	private String department;

	public Employee() {
		super();
	}

	public Employee(String name, String yearOfBirth, float coefficientSalary, String department) {
		super(name, yearOfBirth, coefficientSalary);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	float getSalary() {
		return this.coefficientSalary * 3000000;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ ", department: " + department;
	}
}