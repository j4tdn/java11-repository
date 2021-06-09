package ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Giai PT ax + b = 0");
		double a = 0;
		double b = 0;
		while (true) {
			try {
				System.out.print("Nhap a : ");
				a = Integer.parseInt(ip.nextLine());
				System.out.print("Nhap b : ");
				b = Integer.parseInt(ip.nextLine());
				System.out.println(a + "x" + ((b >= 0) ? "+" + b : b) + " = 0");
				findX(a, b);
				break;
			} catch (Exception e) {
				
				System.out.println("Moi nhap lai");
			}
		}
	}

	private static void findX(double a, double b) {
		if (a == 0) {
			if (b == 0) {
				System.out.println("PT co vo so nghiem");
			} else {
				System.out.println("PT vo nghiem");
			}
		} else {
			if (b == 0) {
				System.out.println("PT co nghiem x = 0");
			} else {
				int x;
				System.out.println("x = " + (-b / a));
			}
		}

	}
}
