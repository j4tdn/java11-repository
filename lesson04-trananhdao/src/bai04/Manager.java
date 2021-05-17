package bai04;

import java.util.Scanner;

public class Manager extends People{
	private double hscv;
	public Manager() {
		
	}
	public Manager(double position) {
		this.hscv = position;
	}
	public double gethscv() {
		return hscv;
	}
	public void sethscv(double position) {
		this.hscv = position;
	}
	@Override
	public double SumSalary() {
		return (getSalary()+hscv)*3000000;
	}
	@Override
	public String toString() {
		return "Manager [position=" + hscv + "]";
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
		System.out.println("he so chuc vu: ");
		sethscv(Double.parseDouble(s.nextLine()));
		
	}
	@Override
	public void output() {
		System.out.printf("%-10s %-10s %-10.2f %-10.2f %-10.2f",
				this.getName(),this.getYear(),this.getSalary(),this.gethscv(), this.SumSalary());
		System.out.println();
	}
	
	

}
