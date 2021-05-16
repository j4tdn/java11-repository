package company;

import java.util.Scanner;

public class Manager extends People{
	private int numOfSubStaff;
	int id = 2;
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNumOfSubStaff() {
		return numOfSubStaff;
	}

	public void setNumOfSubStaff(int numOfSubStaff) {
		this.numOfSubStaff = numOfSubStaff;
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
		
		System.out.print("Name of manager: ");
		this.name = sc.nextLine();
		
		System.out.print("Year of birth: ");
		this.yearOfBirth = sc.nextLine();
		
		System.out.print("Coefficients salary: ");
		this.coefficientsSalary = sc.nextInt();
		
		System.out.print("Coefficients job: ");
		this.coefficientsJob = sc.nextInt();
		
		System.out.print("Num of subordinate staff: ");
		this.numOfSubStaff = sc.nextInt();
		
	}
	
	
}
