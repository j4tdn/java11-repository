package ex04;

public class Manager extends People{
	private int numberOfManagementStaff;

	public Manager() {
		super();
	}

	public Manager(String name, String yearOfBirth, float coefficientSalary, int numberOfManagementStaff) {
		super(name, yearOfBirth, coefficientSalary);
		this.numberOfManagementStaff = numberOfManagementStaff;
	}

	public int getNumberOfManagementStaff() {
		return numberOfManagementStaff;
	}

	public void setNumberOfManagementStaff(int numberOfManagementStaff) {
		this.numberOfManagementStaff = numberOfManagementStaff;
	}

	@Override
	float getSalary() {
		return (this.coefficientSalary) * 2200000;
	}
	
	@Override
	public String toString() {
		return super.toString()
				+ ", number of management staff: " + this.numberOfManagementStaff;
	}
}