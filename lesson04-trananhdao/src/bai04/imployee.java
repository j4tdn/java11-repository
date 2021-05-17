package bai04;

import java.util.Scanner;

public class imployee extends People{
	private String bophan;
	public imployee() {
		
	}
	public imployee(String department) {
		
		this.bophan = department;
	}
	public String getDepartment() {
		return bophan;
	}
	public void setDepartment(String department) {
		this.bophan = department;
	}
	@Override
	public double SumSalary() {
		return getSalary()*1250000;
	}
	@Override
	public void Input() {
        Scanner s = new Scanner(System.in);
		
		System.out.println("name: ");
		setName(s.nextLine());
		System.out.println("year: ");
		setYear(s.nextLine());
		System.out.println("salary: ");
		setSalary(Double.parseDouble(s.nextLine()));
		System.out.println("bo phan: ");
		setDepartment(s.nextLine());
		
	}
	@Override
	public void output() {
		System.out.printf("%-10s %-10s %-10.2f %-10s %-10.2f",
				this.getName(),this.getYear(),this.getSalary(),this.getDepartment(), this.SumSalary());
		System.out.println();
	}
	
	
	

}
