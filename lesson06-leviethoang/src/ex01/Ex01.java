package ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int a, b;
		while (true) {
			try {
				System.out.print("Nhap a = ");
				a = Integer.parseInt(ip.nextLine());
				System.out.print("Nhap b = ");
				b = Integer.parseInt(ip.nextLine());
				System.out.print("result : " + solve(a, b));
				break;
			} catch (ArithmeticException | NumberFormatException e) {
				System.out.println("INVALID NUMBER !!!!");
				System.out.println("=====================");
				System.out.println("Enter A Valid Number ");
			}
		}

	}

	private static double solve(double a, double b) throws ArithmeticException {
		if (a == 0) {
			throw new ArithmeticException("Invalid Number !!!");
		}
		return -b / a;
	}

}
