package homework;

import java.util.Scanner;

public class BT1_LuyThua2 {
	public static void main(String[] args) {
		// kiem tra a number is Power of 2?

		Scanner ip = new Scanner(System.in);

		System.out.print("Enter number: ");
		int number = ip.nextInt();

		if (isPowerOfTwo(number)) {
			System.out.println("Number " + number + " is power of 2");
		} else {
			System.out.println("Number " + number + " is not power of 2");
		}
	}

	private static boolean isPowerOfTwo(int x) {
		return (x != 0) && (x & (x - 1)) == 0;
	}
}
