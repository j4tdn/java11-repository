package Ex02;

import java.util.Scanner;

public class Ex02App {
	public static void main(String[] args) {
		// test case: 1 2 3 4 5 21 15 10 35 14 35 17 14 22 1 5 3 22 84 6 21

		// Initial array from typing
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap day so: ");
		String[] line = scanner.nextLine().split(" ");
		scanner.close();
		int[] array = new int[line.length];
		for (int i = 0; i < line.length; i++) {
			array[i] = Integer.parseInt(line[i]);
		}

		// Set flag index: left - right
		int left = 0, right = array.length - 1;
		while (true) {
			if (array[left] % 5 == 0 && array[left] % 7 != 0) {
				left++;
			} else
				break;
		}

		while (true) {
			if (array[right] % 5 != 0 && array[right] % 7 == 0) {
				right--;
			} else
				break;
		}

		// Sort array
		for (int i = 0; i < array.length; i++) {
			if (i > right)
				break;
			if (array[i] % 7 == 0 && array[i] % 5 != 0) {
				int temp = array[i];
				array[i] = array[right];
				array[right--] = temp;
			}
		}

		for (int i = array.length - 1; i >= 0; i--) {
			if (i < left)
				break;
			if (array[i] % 7 != 0 && array[i] % 5 == 0) {
				int temp = array[i];
				array[i] = array[left];
				array[left++] = temp;
			}
		}

		// Show result
		System.out.println("Day so sau khi sap xep: ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
