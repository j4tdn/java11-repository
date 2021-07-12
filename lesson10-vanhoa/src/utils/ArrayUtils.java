package utils;

import java.util.ArrayList;

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
	
	public static void printf(ArrayList<String> elements) {

		for (String element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
