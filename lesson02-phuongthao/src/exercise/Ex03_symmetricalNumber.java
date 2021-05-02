package exercise;

import java.util.Scanner;

public class Ex03_symmetricalNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter number: ");
		int number = ip.nextInt();
		if (isSymmetricalNumber(number)) {
			System.out.println(number + " is a symmetrical number.");
		} else
			System.out.println(number + " isn't a symmetrical number.");

	}

	private static boolean isSymmetricalNumber(int number) {
		int newNumber = 0;
		int tmp;
		for (tmp = number; number != 0; number /= 10) {

			newNumber = newNumber * 10 + number % 10;
		}

		if (newNumber == tmp) {
			return true;
		} else

			return false;
	}
}
