package Ex04;

public class Manager extends Person {

	private int quantityEmployee;

	public Manager() {
	}

	public Manager(String fullName, int yearOfBirth, float coefficientSalary, int quantityEmployee) {
		super(fullName, yearOfBirth, coefficientSalary);
		this.quantityEmployee = quantityEmployee;
	}

	public int getQuantityEmployee() {
		return quantityEmployee;
	}

	public void setQuantityEmployee(int quantityEmployee) {
		this.quantityEmployee = quantityEmployee;
	}

	@Override
	public String toString() {
		return "Manager [FullName=" + getFullName() + ", YearOfBirth=" + getYearOfBirth() + ", CoefficientSalary="
				+ getCoefficientSalary() + ", quantityEmployee=" + quantityEmployee + "]";
	}

	@Override
	public int calSalary() {
		return (int) ((this.getCoefficientSalary()) * 2200000);
	}
}
