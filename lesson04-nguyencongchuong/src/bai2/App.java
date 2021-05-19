package bai2;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		int size = 0;

		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập số phần tử mảng: ");
		size = ip.nextInt();

		int[] digits = new int[size];

		for (int i = 0; i < size; i++) {
			System.out.printf("a[%d] = ", i);
			digits[i] = ip.nextInt();
		}

		System.out.println("Dãy số: ");
		for (int i = 0; i < size; i++) {
			System.out.print(digits[i] + " ");
		}
		sortDigits(digits);
		System.out.println("\nDãy số được sắp xếp thành: ");
		show(digits);
	}

	private static void sortDigits(int[] digits) {
		int temp = digits[0];
		int size = digits.length;
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (digits[j] % 7 == 0 && digits[j] % 5 != 0) {
					temp = digits[j];
					digits[j] = digits[i];
					digits[i] = temp;
				} else if (digits[j] % 5 == 0 && digits[j] % 7 != 0) {
					int x = size - 1;
					temp = digits[j];
					digits[j] = digits[x];
					digits[x] = temp;
					x--;
					size--;
					j--;

				}
			}
		}
	}

	private static void show(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			System.out.print(digits[i] + " ");
		}
	}
}
