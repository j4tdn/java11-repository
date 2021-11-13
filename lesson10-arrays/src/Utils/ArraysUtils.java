package Utils;

import java.util.Arrays;

import bean.SortOrder;

public class ArraysUtils {
	public ArraysUtils() {
		// TODO Auto-generated constructor stub
	}

	public static void sort(int[] digits, SortOrder order) {
		Arrays.sort(digits);
		if (order == SortOrder.DESC) {
			reserver(digits);
		}
	}

	public static void reserver(int[] rev) {
		for (int i = 0; i < rev.length / 2; i++) {
			int tmp = rev[i];
			rev[i] = rev[rev.length - i - 1];
			rev[rev.length - i - 1] = tmp;
		}
	}

	public static void printf(int[] a) {
		for (Object digit : a) {
			System.out.println(digit + " ");

		}
	}

	public static void printf(String[] a) {
		for (Object digit : a) {
			System.out.println(digit + " ");
		}
	}

	public static void printf(Object[] a) {
		for (Object digit : a) {
			System.out.println(digit + " ");
		}
	}
}
