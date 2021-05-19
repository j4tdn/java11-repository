package Ex04;

public class Employee extends Person {
	private String departmentName;

	public Employee() {
	}

	public Employee(String fullName, int yearOfBirth, float coefficientSalary, String departmentName) {
		super(fullName, yearOfBirth, coefficientSalary);
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Employee [FullName=" + getFullName() + ", YearOfBirth=" + getYearOfBirth() + ", CoefficientSalary="
				+ getCoefficientSalary() + ", departmentName=" + departmentName + "]";
	}

	@Override
	public int calSalary() {
		// TODO Auto-generated method stub
		return (int) ((this.getCoefficientSalary()) * 1250000);
	}

}
