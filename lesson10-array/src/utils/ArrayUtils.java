package utils;

import java.util.Arrays;

import bean.SortOder;
import bean.Student;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void sort(int[] digits, SortOder order) {
		Arrays.sort(digits);
		if(order == SortOder.DESC) {
			reverse(digits);
		}
	}
	
	public static void reverse(int[] origin) {

		for (int i = 0; i < origin.length / 2; i++) {
			int tmp = origin[i];
			origin[i] = origin[origin.length - i - 1];
			origin[origin.length - i - 1] = tmp;
		}
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

	public static void printf(Student[] elements) {
		for (Student element : elements) {
			System.out.println(element);
		}
		System.out.println();
	}

}
