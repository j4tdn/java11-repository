package homework;

import java.util.Scanner;

public class BT4_FindMaxOddNumber {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		// input values for array
		int quantity = 0;
		do {
			System.out.print("Input quantity of array : ");
			quantity = ip.nextInt();
		} while (quantity < 0);

		int[] serieNumber = new int[quantity];
		int i = 0;
		while (i < quantity) {
			System.out.print("Input number " + (i + 1) + ": ");
			int number = ip.nextInt();
			serieNumber[i++] = number;
		}

		// print created array
		System.out.print("The array need to check is: ");
		for (i = 0; i < quantity; i++) {
			System.out.print(serieNumber[i] + " ");
		}
		System.out.println();

		// find max odd number
		System.out.print("The max odd number is: ");
		int maxOdd = 0;
		for (int j = 0; j < serieNumber.length; j++) {
			if (serieNumber[j] % 2 != 0) {
				if (maxOdd < serieNumber[j]) {
					maxOdd = serieNumber[j];
				}
			}
		}
		System.out.println(maxOdd);
	}

}
