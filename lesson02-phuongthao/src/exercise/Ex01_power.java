package exercise;

import java.util.Scanner;

public class Ex01_power {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = ip.nextInt();

		if (isPowerOf2(number)) {
			System.out.println(number + " is power of 2");
		} else
			System.out.println(number + " isn't power of 2");
	}

	private static boolean isPowerOf2(int number) {
		if (number < 1)
			return false;
		if (number == 1) // 2^0 = 1;
			return true;
		if (number % 2 == 1)
			return false;
		return isPowerOf2(number / 2);

	}

}
