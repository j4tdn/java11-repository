package entities;

public abstract class People {
	private String name;
	private int yearOfBirth;
	private float coeSalary;

	public People() {
	}

	public People(String name, int yearOfBirth, float coeSalary) {
		super();
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.coeSalary = coeSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public float getCoeSalary() {
		return coeSalary;
	}

	public void setCoeSalary(float coeSalary) {
		this.coeSalary = coeSalary;
	}

	abstract float getSalary();

}
