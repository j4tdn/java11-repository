package bt01;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("giai pt ax + b = 0");
		double a, b;
		while (true) {
			try {
				System.out.print("Nhap so a: ");
				a = Double.parseDouble(ip.nextLine());
				while (a == 0) {
					System.out.println("Nhap lai a: ");
					a = Double.parseDouble(ip.nextLine());
				}
				break;
			} catch (Exception e) {
				System.out.println("Nhap lai a");
			}
		}
		while (true) {
			try {
				System.out.print("Nhap b: ");
				b = Double.parseDouble(ip.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap lai");
			}
		}
		System.out.println("x= " + -b / a);
	}
}
