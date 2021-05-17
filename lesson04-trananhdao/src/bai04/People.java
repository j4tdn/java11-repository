package bai04;

public abstract class People {
	private String name;
	private String year;
	private double salary;
	
	public People() {
		
	}

	public People(String name, String year, double salary) {
		
		this.name = name;
		this.year = year;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Information [name=" + name + ", year=" + year + ", salary=" + salary + "]";
	}

	public abstract double SumSalary() ;
	public abstract void Input() ;
	public abstract void output() ;
	

}
