package ex04;

import java.util.Arrays;

public class Ex04App {
	public static void main(String[] args) {
		int[] input1 = new int[] { 21, 42, 63 };
		int[] input2 = new int[] { 7, 14, 21, 28, 35, 42, 56, 63 };
		int[] input3 = new int[] { 6, 12, 18, 24, 30, 36, 42, 48, 54, 60 };
		System.out.println(getLeastCommonMultiple(input1)); // 126
		System.out.println(getLeastCommonMultiple(input2)); // 2520
		System.out.println(getLeastCommonMultiple(input3)); // 15120
	}

	private static int getLeastCommonMultiple(int[] array) {
		Arrays.sort(array);
		int result = array[0];
		for (var i : array) {
			result = getLeastCommonMultiple(result, i);
		}
		return result;
	}

	private static int getLeastCommonMultiple(int a, int b) {
		for (int i = a > b ? a : b; i < a * b; i++) {
			if (i % a == 0 && i % b == 0) {
				return i;
			}
		}
		return a * b;
	}
}
