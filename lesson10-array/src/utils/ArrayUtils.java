package utils;

import java.util.Arrays;

import bean.Item;
import bean.SortOrder;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void sort(int[] digits, SortOrder order) {
		Arrays.sort(digits);
		if(order == SortOrder.DESC) {
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

	public static void printf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}
		// break line
		System.out.println();
	}

	public static void printf(String[] elements) {
		for (String element : elements) {
			System.out.print(element + " ");
		}
		// break line
		System.out.println();
	}

	public static void printf(Item[] items) {
		for (Item item : items) {
			System.out.print(item);
			System.out.println();
		}
		// break line
		System.out.println();
	}
}
