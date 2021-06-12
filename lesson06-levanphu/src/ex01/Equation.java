package ex01;

import java.util.Scanner;

public class Equation {
	public static void main(String[] args) {
		Scanner id = new Scanner(System.in);
		int a ; int b;
		while(true) {
			try {
				System.out.println("Nhap a = ");
				a = Integer.parseInt(id.nextLine());
				System.out.println("Nhap b = ");
				b = Integer.parseInt(id.nextLine());
				System.out.println("test equation: " + Equation(a, b));
				break;
			}catch(ArithmeticException | NumberFormatException e) {
				System.out.println("Divide 0 error !!");
				System.out.println("Please re-enter...");
			}
		}
	}
	private static double Equation(double a,double b) throws ArithmeticException{
		if(a==0) {
			throw new ArithmeticException();
		}
		return -b/a;
	}

}
