package utils;

import bean.Item;

public class ArrayUtils {
	private ArrayUtils() {
		
	}
	
	public static void printf(Item[] items) {
		for (Item item: items) {
			System.out.println(item + " ");
		}
		// break line
		System.out.println();
	}
	
	public static void printf(String[] elements) {
		for (String element: elements) {
			System.out.print(element + " ");
		}
		// break line
		System.out.println();
	}
	
	public static void printf(int[] elements) {
		for (int element: elements) {
			System.out.print(element + " ");
		}
		// break line
		System.out.println();
	}
}
