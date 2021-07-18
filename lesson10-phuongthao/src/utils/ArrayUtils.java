package utils;

import java.util.Arrays;

import Ex04.Student;

public class ArrayUtils {
	private ArrayUtils() {

	}

	public static void sort(int[] digits, SortOrder order) {
		Arrays.sort(digits);
		if (order.equals(SortOrder.DESC)) {
			reverse(digits);
		}
	}

	public static void reverse(int[] digits) {
		for (int i = 0; i < digits.length / 2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length - i - 1];
			digits[digits.length - i - 1] = tmp;
		}
	}
	
	public static void reverse(String[] digits) {
		for (int i = 0; i < digits.length / 2; i++) {
			String tmp = digits[i];
			digits[i] = digits[digits.length - i - 1];
			digits[digits.length - i - 1] = tmp;
		}
	}

	public static void printf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}

		System.out.println();

	}

	public static void printf(Student[] elements) {
		for (Student element : elements) {
			System.out.println(element + " ");
		}

	}

	public static void printf(String[] elements) {
		for (String element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();

	}

	public enum SortOrder {
		ASC, DESC
	}

}
