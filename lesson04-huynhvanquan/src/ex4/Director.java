package ex4;

import java.util.Scanner;

public class Director extends People {
	private float posCoeff;
	public Director() {}
	public Director(String name, String birthYear, float salaryCoeff, float posCoeff) { 
		super(name, birthYear, salaryCoeff);
		this.posCoeff = posCoeff;
	}
	public float getPosCoeff() {
		return posCoeff;
	}
	public void setPosCoeff(float posCoeff) {
		this.posCoeff = posCoeff;
	}
	public float getSalry() {
		return (getSalaryCoeff() + getPosCoeff()) * 3000000;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the information of director");
		System.out.println("======");
		System.out.println("Enter name: ");
		this.setName(sc.nextLine());
		System.out.println("Enter year of birth: ");
		this.setBirthYear(sc.nextLine());
		System.out.println("Enter salary coefficient: ");
		this.setSalaryCoeff(sc.nextFloat());
		System.out.println("Enter position coefficient: ");
		this.setPosCoeff(sc.nextFloat());
	}
	public String toString(int mode) {
		if (mode == 1) {
			return String.format("%-10s %-10s %-6s %5.2f %10.2f", "Director: ", getName(), getBirthYear(), getSalaryCoeff(), getPosCoeff());
		}
		if (mode == 2) {
			return String.format("%-20s  %20.2f", "Director: ", getSalry());
		}
		return null;
	}
	
}
