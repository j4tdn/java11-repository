package sorting;

public class Sort {
	public static void main(String[] args) {

		int[] digits = { 5, 8, 4, 2, 11, 6, 9 };
		print(digits);
		System.out.println("=====================");
//		BubleSort(digits);
//		SelectionSort(digits);
//		InsertionSort(digits);
		print(digits);

	}

	private static void print(int[] digits) {
		for (int digit : digits) {
			System.out.print(digit + " ");
		}
		System.out.println();
	}

	private static void BubleSort(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			for (int j = digits.length - 1; j > i; j--) {
				if (digits[j] < digits[j - 1]) {
					int tmp = digits[j];
					digits[j] = digits[j - 1];
					digits[j - 1] = tmp;
				}
			}
		}
	}

	private static void SelectionSort(int[] digits) {
		int min = digits[0];
		for (int i = 0; i < digits.length; i++) {
			min = i;
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[min] > digits[j]) {
					min = j;
				}
			}
			if (min != i) {
				int tmp = digits[i];
				digits[i] = digits[min];
				digits[min] = tmp;
			}

		}
	}

	private static void InsertionSort(int[] digits) {
		for (int i = 1; i < digits.length; i++) {

			int j = i - 1;
			int tmp = digits[i];
			while (j >= 0 && tmp < digits[j]) {
				digits[j + 1] = digits[j];
				j--;
			}
			digits[j + 1] = tmp;

		}
	}

}
