package company;

import java.util.Scanner;

public class Director extends People {
	int id = 1;
	
	public Director() {
		// TODO Auto-generated constructor stub
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
		
		System.out.print("Name of director: ");
		this.name = sc.nextLine();
		
		System.out.print("Year of birth: ");
		this.yearOfBirth = sc.nextLine();
		
		System.out.print("Coefficients salary: ");
		this.coefficientsSalary = sc.nextInt();
		
		System.out.print("Coefficients job: ");
		this.coefficientsJob = sc.nextInt();
	}
}
