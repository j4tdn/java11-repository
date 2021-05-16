package company;

import java.util.Scanner;

public class Employee extends People{
	private String departmentName;
	int id = 3;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Name of employee: ");
		this.name = sc.nextLine();
		
		System.out.print("Year of birth: ");
		this.yearOfBirth = sc.nextLine();
		
		System.out.print("Coefficients salary: ");
		this.coefficientsSalary = sc.nextInt();
		
		System.out.print("Coefficients job: ");
		this.coefficientsJob = sc.nextInt();
		
		sc.nextLine();
		System.out.print("Department: ");
		this.departmentName = sc.nextLine();
	}
	
}
