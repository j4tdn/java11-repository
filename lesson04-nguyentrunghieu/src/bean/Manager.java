package bean;

public class Manager extends Person {
	private int quantityEmployee;

	public Manager() {
	}

	public Manager(String name, String birthYear, float salaryCoeff, int quantityEmployee) {
		super(name, birthYear, salaryCoeff);
		this.quantityEmployee = quantityEmployee;
	}

	public int getQuantityEmployee() {
		return quantityEmployee;
	}

	public void setQuantityEmployee(int quantityEmployee) {
		this.quantityEmployee = quantityEmployee;
	}

	public float calSalary() {
		return this.getSalaryCoeff() * 2200000;
	}

	@Override
	public String toString() {
		return "Manager [quantityEmployee = " + quantityEmployee + ", getQuantityEmployee = " + getQuantityEmployee()
				+ ", calSalary = " + calSalary() + ", getName = " + getName() + ", getBirthYear = " + getBirthYear()
				+ ", getSalaryCoeff = " + getSalaryCoeff() + " ]";
	}

}
