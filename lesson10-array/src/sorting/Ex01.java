package sorting;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 1, 5, 9, 4, 6, 11 };
		sort(digits);
		ArrayUtils.printf(digits);
		BubbleSort(digits);
		ArrayUtils.printf(digits);
	}

	// bubble sort 
	private static void sort(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < digits.length - i - 1; j++) {
				if (digits[j] > digits[j + 1]) {
					swap(digits, j, j + 1);
				}
			}
		}
	}

	// Bubble sort 
	private static void BubbleSort(int[] digits) {
		for (int i = digits.length - 1; i > 0; i--) {
			for (int j = 0; j < i ; j++) {
				if (digits[j] < digits[i]) {
					swap(digits, j, i);
				}
			}
		}
	}
	
	private static void swap(int[] digit ,int i, int j) {
		int tmp = digit[i];
		digit[i] = digit[j];
		digit[j] = tmp;
		
	}
}
