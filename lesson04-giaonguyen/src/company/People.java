package company;

import java.util.Scanner;

public class People {
	
	String name;
	String yearOfBirth;
	int coefficientsSalary;
	int coefficientsJob;
	int id = 0;
	
	public People() {
		// TODO Auto-generated constructor stub
	}
	
	public People(String name, String yearOfBirth, int coefficientsSalary, int coefficientsJob) {
		super();
		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.coefficientsSalary = coefficientsSalary;
		this.coefficientsJob = coefficientsJob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(String yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getCoefficientsSalary() {
		return coefficientsSalary;
	}

	public void setCoefficientsSalary(int coefficientsSalary) {
		this.coefficientsSalary = coefficientsSalary;
	}

	public int getCoefficientsJob() {
		return coefficientsJob;
	}

	public void setCoefficientsJob(int coefficientsJob) {
		this.coefficientsJob = coefficientsJob;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", yearOfBirth=" + yearOfBirth + ", coefficientsSalary=" + coefficientsSalary
				+ "]";
	}
	
	public void inputInfo() {	
		Scanner sc = new Scanner(System.in);
		System.out.print("Name: ");
		this.name = sc.nextLine();
		System.out.print("Year of birth: ");
		this.yearOfBirth = sc.nextLine();
		System.out.print("Coefficients salary: ");
		this.coefficientsSalary = sc.nextInt();
		System.out.print("Coefficients job: ");
		this.coefficientsJob = sc.nextInt();
	}
	
}
