package utils;

import java.util.Arrays;

import bean.SortOder;

public class ArrayUtils {
	private ArrayUtils(){
		
	}

	public static void printf(Object[] elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
	}
	
	public static void printf(int[] elements) {
		for (int element: elements) {
			System.out.println(element + " ");
		}
	}
	
	public static void printf(String[] elements) {
		for (String element: elements) {
			System.out.println(element + " ");
		}
	}
	
	public static void sort (int[] digits, SortOder order) {
		Arrays.sort(digits);
		if (order == SortOder.DESC) {
			reverse(digits);
		}
	}
	
	public static int[] reverse(int[] digits) {
		for (int i = 0; i < digits.length / 2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length - 1 - i];
			digits[digits.length - 1 - i] = tmp;
		}
		return digits;
	}
	
}
