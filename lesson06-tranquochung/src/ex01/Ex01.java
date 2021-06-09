package ex01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		int a;
		int b;
		Scanner input = new Scanner(System.in);
		System.out.println("<< NHẬP HỆ SỐ CỦA PHƯƠNG TRÌNH ax + b = 0 >>");
		
		while(true) {
			while(true) {
				try {
					System.out.println("NHẬP HỆ SỐ a: ");
					a = Integer.parseInt(input.nextLine());
					System.out.println("NHẬP HỆ SỐ b: ");
					b = Integer.parseInt(input.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("BẠN PHẢI NHẬP SỐ HÃY NHẬP LẠI!!");
				}
			}
			
			
			try {
				System.out.println("NGHIỆM CỦA PHƯƠNG TRÌNH LÀ: " + equation(a,b));
				break;
			} catch (ArithmeticException e) {
				System.out.println("HỆ SỐ a = 0 !!");
			}
		}
	}

	private static double equation(int a, int b) throws ArithmeticException {
		if (a == 0) {
			throw new ArithmeticException();
		}
		return -b / a;
	}
}
