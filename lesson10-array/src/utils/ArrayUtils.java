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
			reverseArr(digits);
		}
	}
	
	private static void reverseArr(int[] digits) {
		
		for(int i = 0; i < digits.length / 2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length - 1 - i];
			digits[digits.length - 1 - i] = tmp;
		}
		
	}
	
	
	public static void printf(int[] elements) {
		for(int element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void printf(String[] elements) {
		for(String element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void printf(Item[] elements) {
		for(Item element : elements) {
			System.out.println(element);
		}
//		System.out.println();
	}
}
