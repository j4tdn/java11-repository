package ex02;

import java.util.Arrays;

public class Ex02App {
	public static void main(String[] args) {
		int[] input1 = new int[] { 3, 2, 1, 6, 5 };
		int[] input2 = new int[] { 3, 7, 9, 2, 1, 6, 5, 4, 10 };
		System.out.println(getMissingNumber(input1)); // result =4
		System.out.println(getMissingNumber(input2)); // result =8
	}

	private static int getMissingNumber(int[] a) {
		Arrays.sort(a);
		for (int i = 1; i < a.length; i++) {
			if (a[i] - a[i - 1] != 1) {
				return a[i] - 1;
			}
		}
		return Integer.MIN_VALUE;
	}
}
