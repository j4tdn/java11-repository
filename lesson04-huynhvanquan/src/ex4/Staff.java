package ex4;

import java.util.Scanner;

public class Staff extends People{
	private String department;
	public Staff() {}
	public Staff(String name, String birthYear, float salaryCoeff, String department) {
		super(name, birthYear, salaryCoeff);
		this.department = department;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the information of staff");
		System.out.println("======");
		System.out.println("Enter name: ");
		this.setName(sc.nextLine());
		System.out.println("Enter year of birth: ");
		this.setBirthYear(sc.nextLine());
		System.out.println("Enter salary coefficient: ");
		this.setSalaryCoeff(sc.nextFloat());
		System.out.println("Enter department: ");
		sc.nextLine();
		this.setDepartment(sc.nextLine());
	}
	private float getSalry() {
		return getSalaryCoeff()*1250000;
	}
	@Override
	public String toString() {
		return super.toString() + " [department=" + department + "]";
	}

	public String toString(int mode) {
		if (mode == 1) {
			return String.format("%-10s %-10s %-6s %5.2f %10s", "Staff: ", getName(), getBirthYear(), getSalaryCoeff(), getDepartment());
		}
		if (mode == 2) {
			return String.format("%-20s  %20.2f", "Staff: ", getSalry());
		}
		return null;
	}

	
	
}
