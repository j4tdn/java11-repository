package ex04;

import java.util.Scanner;

public class Manager extends People {
	private int NumberOfEmployeesUnderManager;
	public Manager() {
	}
	public Manager(String name, String yearOfBirth, float coefficientSalary, int numberOfEmployeesUnderManager) {
		super(name, yearOfBirth, coefficientSalary);
		NumberOfEmployeesUnderManager = numberOfEmployeesUnderManager;
	}
	public int getNumberOfEmployeesUnderManager() {
		return NumberOfEmployeesUnderManager;
	}
	public void setNumberOfEmployeesUnderManager(int numberOfEmployeesUnderManager) {
		NumberOfEmployeesUnderManager = numberOfEmployeesUnderManager;
	}
	private float salary() {
		return getCoefficientSalary() * 2200000;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter manager's information");
		System.out.println("============");
		System.out.println("Enter name: ");
		this.setName(sc.nextLine());
		System.out.println("Enter year of birth: ");
		this.setYearOfBirth(sc.nextLine());
		System.out.println("Enter salary coefficient: ");
		this.setCoefficientSalary(sc.nextFloat());
		System.out.println("Enter number of employees under manager: ");
		this.setNumberOfEmployeesUnderManager(sc.nextInt());
	}
	public void printformat() {
		System.out.printf("%5s %6s %6s %6s %6s \n", getName(), getYearOfBirth(), getCoefficientSalary(), getNumberOfEmployeesUnderManager());
			
		System.out.printf("%20s  %20f", "Manager: ", salary());
		this.printformat();
	    this.printformat();
	    this.printformat();
}
}
