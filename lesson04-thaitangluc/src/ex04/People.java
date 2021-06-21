package ex04;

public class People {
	private String name;
	private int yearOB;
	private double coSalary;
	
	public People() {
	}

	public People(String name, int yearOB, double coSalary) {
		this.name = name;
		this.yearOB = yearOB;
		this.coSalary = coSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYearOB() {
		return yearOB;
	}

	public void setYearOB(int yearOB) {
		this.yearOB = yearOB;
	}

	public double getCoSalary() {
		return coSalary;
	}

	public void setCoSalary(double coSalary) {
		this.coSalary = coSalary;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", yearOB=" + yearOB + ", coSalary=" + coSalary + "]";
	}
	
	
	
}
