package hw4;

public class Director extends People {
	private int position;

	public Director() {
	}

	public Director(String name, int birthYear, double salary, int position) {
		super(name, birthYear, salary);
		this.position = position;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-15d%20s%25s", getName(), getBirthYear(), "Director", totalSalary());
	}

	@Override
	public double totalSalary() {
		return (this.getSalary() + this.position) * 3000000;
	}
}
