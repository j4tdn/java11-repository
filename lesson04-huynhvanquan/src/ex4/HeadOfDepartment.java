package ex4;

import java.util.Scanner;

public class HeadOfDepartment extends People {
	private int staffNumber;
	public HeadOfDepartment() {}
	public HeadOfDepartment(String name, String birthYear, float salaryCoeff, int staffNumber) {
		super(name, birthYear, salaryCoeff);
		this.staffNumber = staffNumber;
	}
	public int getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}
	private float getSalry() {
		return getSalaryCoeff() * 2200000;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the information of head of deparment");
		System.out.println("======");
		System.out.println("Enter name: ");
		this.setName(sc.nextLine());
		System.out.println("Enter year of birth: ");
		this.setBirthYear(sc.nextLine());
		System.out.println("Enter salary coefficient: ");
		this.setSalaryCoeff(sc.nextFloat());
		System.out.println("Enter position staff number: ");
		this.setStaffNumber(sc.nextInt());
	}
	public String toString(int mode) {
		if (mode == 1) {
			return String.format("%-10s %-10s %-6s %5.2f %10d", "HOD: ", getName(), getBirthYear(), getSalaryCoeff(), getStaffNumber());
		}
		if (mode == 2) {
			return String.format("%-20s  %20.2f", "Head of department: ", getSalry());
		}
		return null;
	}
}
