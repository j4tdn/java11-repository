package homework;

import java.util.Scanner;

public class BT3_SoDoiXung {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		System.out.print("Enter number: ");
		String inputString = ip.nextLine();
		;

//		System.out.println(isSymmetricalNumber(inputString));

		if (isSymmetricalNumber(inputString)) {
			System.out.println(inputString + " la so doi xung");
		} else {
			System.out.println(inputString + " khong phai la so doi xung");
		}
	}

	private static boolean isSymmetricalNumber(String inputString) {
		String reverseString = "";
		int inputStringLength = inputString.length();
		int i = inputStringLength - 1;

		do {
			reverseString = reverseString + inputString.charAt(i);
			i--;
		} while (i >= 0);

		return reverseString.equals(inputString);

	}

}
