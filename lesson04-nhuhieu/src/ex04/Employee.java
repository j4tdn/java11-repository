package ex04;

import java.util.Scanner;

public class Employee extends People {
	private String departmentName;

	public Employee() {
	}

	public Employee(String name, String yearOfBirth, float coefficientSalary, String departmentName) {
		super(name, yearOfBirth, coefficientSalary);
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the information of staff");
		System.out.println("============");
		System.out.println("Enter name: ");
		this.setName(sc.nextLine());
		System.out.println("Enter year of birth: ");
		this.setYearOfBirth(sc.nextLine());
		System.out.println("Enter salary coefficient: ");
		this.setCoefficientSalary(sc.nextFloat());
		System.out.println("Enter department: ");
		sc.nextLine();
		this.setDepartmentName(sc.nextLine());
	}

	private float Salary() {
		return getCoefficientSalary() * 1250000;
	}

	public void printformat() {
		System.out.printf("%5s %6s %6s %6s %6s \n", getName(), getYearOfBirth(), getCoefficientSalary(),
				getDepartmentName());

		System.out.printf("%20s  %20f", "Director: ", Salary());
		this.printformat();
		this.printformat();
		this.printformat();
	}
}
