package Ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("===== GIẢI PHƯƠNG TRÌNH: ax + b =0 =====");
		float a;
		float b;
		while (true) {
			while (true) {
				try {
					System.out.print("Nhập a: ");
					a = Float.parseFloat(ip.nextLine());
					System.out.print("Nhập b: ");
					b = Float.parseFloat(ip.nextLine());
					break;

				} catch (NumberFormatException e) {
					System.out.println("Nhập sai kiểu dữ liệu. Mời nhập lại!");
				}
			}
			try {
				System.out.println("================================");
				System.out.println("Chương trình có nghiệm x = " + divide(a, b));
				break;
			} catch (ArithmeticException e) {
				System.out.println("Hệ số a phải khác 0. Mời nhập lại!");
			}
		}
	}

	private static float divide(float a, float b) throws ArithmeticException {
		if (a == 0) {
			throw new ArithmeticException();
		}
		return -b / a;
	}
}
