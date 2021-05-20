package ex04;

public class Employee extends People {
	private String departmentName;
	
	public Employee() {
		super();
	}

	public Employee(String name, int yearOfBirth, float coEffiencts, String departmentName) {
		super(name, yearOfBirth, coEffiencts);
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	float getSalary() {
		// TODO Auto-generated method stub
		return this.getCoEffiencts()*1250000;
	}
	
	@Override
	public String toString() {
		return toString() + getCoEffiencts() + this.departmentName; 
	}
	
	
}
