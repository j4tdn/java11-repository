package bean;

public class Staff extends Person {
	private String departmentName;

	public Staff() {
	}

	public Staff(String name, String birthYear, float salaryCoeff, String departmentName) {
		super(name, birthYear, salaryCoeff);
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
		return "Staff [departmentName = " + departmentName + ", calSalary = " + calSalary() + ", getName = " + getName()
				+ ", getBirthYear = " + getBirthYear() + ", getSalaryCoeff = " + getSalaryCoeff() + "]";
	}

	public float calSalary() {
		return this.getSalaryCoeff() * 1250000;
	}

}
