package entities;

public class Manager extends People {
	private int numberStaff;

	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, int yearOfBirth, float coeSalary, int numberStaff) {
		super(name, yearOfBirth, coeSalary);
		this.numberStaff = numberStaff;
	}

	public int getNumberStaff() {
		return numberStaff;
	}

	public void setNumberStaff(int numberStaff) {
		this.numberStaff = numberStaff;
	}

	@Override
	float getSalary() {
		return getCoeSalary() * 2200000;
	}

	@Override
	public String toString() {
		return String.format("%-20s %-20s %-20.2f %20.2f ", "Manager", "", getCoeSalary(), getSalary());

	}

}
