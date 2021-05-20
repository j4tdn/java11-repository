package hw4;

public class HeadOfDepartment extends People {
	private int amount;

	public HeadOfDepartment() {
	}

	public HeadOfDepartment(String name, int birthYear, double salary, int amount) {
		super(name, birthYear, salary);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-15s%20s%25s", getName(), getBirthYear(), "Head of Department", totalSalary());
	}

	@Override
	public double totalSalary() {
		return this.getSalary() * 2200000;
	}

}
