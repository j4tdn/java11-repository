package sorting;

import Utils.ArraysUtils;

public class Ex04 {
	public static void main(String[] args) {
		int[] digits = { 1, 5, 9, 4, 6, 11 };
		for (int i = digits.length - 1; i > 0; i--) {
			int maxidx = -1;
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (digits[j] > max) {
					max = digits[j];
					maxidx = j;
				}
			}
			if (digits[maxidx] > digits[i]) {
				int tmp = digits[i];
				digits[i] = digits[maxidx];
				digits[maxidx] = tmp;
			}
		}
		ArraysUtils.printf(digits);
	}
}
