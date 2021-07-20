package sorting;

import untils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {

		int[] numbers = new int[] { 5, 4, 2, 6, 8, 11 };
		for (int i = numbers.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[i]) {
					swap(numbers, j, j + 1);
				}
			}
		}
		ArrayUtils.printf(numbers);
		
		for (int i = numbers.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (numbers[j] > numbers[i]) {
					swap(numbers, i, j);
				}
			}
		}
		ArrayUtils.printf(numbers);
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
