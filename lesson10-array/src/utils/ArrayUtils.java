package utils;

import bean.Item;

public class ArrayUtils {
	private ArrayUtils() {

	}

	public static void printf(int[] elements) {
		for (int element : elements) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void printf(String[] elements) {
		for (String element : elements) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void printf(Item[] elements) {
		for (Item element : elements) {
			System.out.println(element);
		}

		System.out.println();
	}

}
