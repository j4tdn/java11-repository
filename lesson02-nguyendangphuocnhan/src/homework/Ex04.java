package homework;

import java.util.Scanner;

public class Ex04 {
	// Viết chương trình nhập vào một dãy các số nguyên từ bàn phím.
	// Tìm số lẻ lớn nhất trong dãy số và in ra.

	public static void main(String[] args) {
		int maxOdd = 0;
		int i;
		Scanner ip = new Scanner(System.in);

		// Input amount of numbers in the array
		System.out.print("Numbers in array are: ");
		int n = Integer.parseInt(ip.nextLine());

		int[] array = new int[n];

		// Input all of the numbers
		System.out.print("Those numbers are: ");
		for (i = 0; i < n; i++) {
			array[i] = ip.nextInt();
		}
		for (i = 0; i < n; i++) {
			if (array[i] % 2 != 0) {
				if (maxOdd < array[i])
					maxOdd = array[i];
			}
		}
		System.out.println("Max Odd number is: " + maxOdd);
	}
}
