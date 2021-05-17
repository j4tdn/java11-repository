package bai04;

import java.util.Scanner;

public class Leader extends People {
	private int slnv;
	public Leader() {
		
	}
	public Leader(int slnv) {
		
		this.slnv = slnv;
	}
	public int getSlnv() {
		return slnv;
	}
	public void setSlnv(int slnv) {
		this.slnv = slnv;
	}
	@Override
	public double SumSalary() {
		
		return getSalary()*220000;
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
		System.out.println("slnv: ");
		setSlnv(Integer.parseInt(s.nextLine()));
		
	}
	@Override
	public void output() {
		System.out.printf("%-10s %-10s %-10.2f %-10d %-10.2f",
				this.getName(),this.getYear(),this.getSalary(),this.getSlnv(), this.SumSalary());
		System.out.println();
	}

}
