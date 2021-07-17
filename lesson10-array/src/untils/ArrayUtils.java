package untils;

import java.util.Arrays;

import bean.SortOrder;

public class ArrayUtils {
	private ArrayUtils() {
	}

	public static void sort(int[] numbers, SortOrder order) {
		Arrays.sort(numbers);
		if (order == SortOrder.DESC) {
			reverse(numbers);
		}
	}

	public static void printf(int[] elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
	}

	public static void printf(Object[] elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
	}

	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void reverse(int[] origin) {
		for (int i = 0; i < origin.length / 2; i++) {
			int tmp = origin[i];
			origin[i] = origin[origin.length - i - 1];
			origin[origin.length - i - 1] = tmp;
		}
	}

}
