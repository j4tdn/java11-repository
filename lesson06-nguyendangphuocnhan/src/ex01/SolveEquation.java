package ex01;

import java.util.Scanner;

public class SolveEquation {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		float a = 0;
		float b = 0;
		while (true) {
			while (true) {
				try {
					System.out.print("Input a: ");
					a = Float.parseFloat(ip.nextLine());
					System.out.print("Input b: ");
					b = Float.parseFloat(ip.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Wrong format!!! Only accept numbers!!!");
				}
			}

			try {
				System.out.println("x = " + divide(a, b));
				break;
			} catch (ZeroException e) {
				System.out.println("Number a must be a non-zero value ");
			}
		}
	}

	private static float divide(float a, float b) throws ZeroException {
		if (a == 0) {
			throw new ZeroException("Please enter a non-zero value");
		}
		return -b / a;
	}
}
