package entities;

public class Staff extends People {
	private String DepartmentName;

	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(String name, int yearOfBirth, float coeSalary, String departmentName) {
		super(departmentName, yearOfBirth, coeSalary);
		DepartmentName = departmentName;
	}

	public String getDepartmentName() {
		return DepartmentName;
	}

	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}

	@Override
	float getSalary() {
		return getCoeSalary() * 1250000;
	}

	@Override
	public String toString() {
		return String.format("%-20s %-20s %-20.2f %20.2f ", "Staff", "", getCoeSalary(), getSalary());

	}

}
