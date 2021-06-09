package homework01;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		float a;
		float b;

		Scanner ip = new Scanner(System.in);

		System.out.println("======= SOLVE THE EQUATION AX + B = 0 =========");
		while (true) {
			while (true) {
				try {
					System.out.print("\nEnter a: ");
					a = Float.parseFloat(ip.nextLine());
					System.out.print("Enter b: ");
					b = Float.parseFloat(ip.nextLine());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Enter wrong. Please enter again!!!");
				}
			}
			try {
				System.out.println("result: " + divide((-b), a));
				break;
			} catch (homework01.ZeroException e) {
				e.printStackTrace();
			}
		}

	}

	private static float divide(float a, float b) throws ZeroException {
		if (b == 0) {
			throw new ZeroException("Please Enter a non-zero value");
		}
		return a / b;
	}
}
