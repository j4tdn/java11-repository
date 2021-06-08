package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.println("ax + b = 0;");
		Scanner ip = new Scanner(System.in);
		float a = 0;
		float b = 0;
		while (true) {
			while (true) {
				try {
					System.out.print("Nhập vào a: ");
					a = Float.parseFloat(ip.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("a phải là số!");
				}
			}
			while (true) {
				try {
					System.out.print("Nhập vào b: ");
					b = Float.parseFloat(ip.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("b phải là số!");
				}
			}
			try {
				System.out.println("x = " + firstDegreeEquation(a, b));
				break;
			} catch (ZeroException e) {
				System.out.println("a phải khác 0!");
			}
		}

	}

	private static float firstDegreeEquation(float a, float b) throws ZeroException {
		if (a == 0) {
			throw new ZeroException();
		}
		float x = 0;
		x = -b / a;
		System.out.println("với a = " + a + ", " + "b = " + b);
		return x;
	}
}
