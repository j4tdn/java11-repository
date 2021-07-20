package utils;

import java.util.Arrays;

import bean.Item;
import bean.SortOrder;

public class ArrayUtils {
	public ArrayUtils() {
		// TODO Auto-generated constructor stub
	}
	
	 public static void sort(int[] digits, SortOrder order) {
		 Arrays.sort(digits);
		 if (order == SortOrder.DES) {
			 reverse(digits);
		 }
	 }
	
	public static void reverse(int[] digits) {
		for (int i = 0; i < digits.length/2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length - i + 1];
			digits[digits.length - i + 1] = tmp;
		}
	}
	
	public static void printf(Item[] items) {
		for (Item item : items) {
			System.out.println(item + " ");
		}
	}
	
	public static void printf(String[] elements) {
		for (String element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void printf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
