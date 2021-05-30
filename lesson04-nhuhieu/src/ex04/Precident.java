package ex04;

import java.util.Scanner;

public class Precident extends People {
	private float coefficientsPos;
	public Precident() {
	}
	public Precident(String name, String yearOfBirth, float coefficientSalary, float coefficientsPos) {
		super(name, yearOfBirth, coefficientSalary);
		this.coefficientsPos = coefficientsPos;
	}
	public float getCoefficientsPos() {
		return coefficientsPos;
	}
	public void setCoefficientsPos(float coefficientPos) {
		this.coefficientsPos = coefficientPos;
	}
	public float getSalry() {
		return (getCoefficientSalary() + getCoefficientsPos()) * 3000000;
	}
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter president's information");
		System.out.println("=============");
		System.out.println("Enter name: ");
		this.setName(sc.nextLine());
		System.out.println("Enter year of birth: ");
		this.setYearOfBirth(sc.nextLine());
		System.out.println("Enter salary coefficient: ");
		this.setCoefficientSalary(sc.nextFloat());
		System.out.println("Enter position coefficient: ");
		this.setCoefficientsPos(sc.nextFloat());
	}
	public void printformat() {
		System.out.printf("%5s %6s %6s %6s %6s \n", getName(), getYearOfBirth(), getCoefficientSalary(),
				getCoefficientsPos());
			
		System.out.printf("%20s  %20f", "Director: ", getSalry());
		this.printformat();
	    this.printformat();
	    this.printformat();

	}
}
