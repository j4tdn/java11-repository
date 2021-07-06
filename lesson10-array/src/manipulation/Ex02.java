package manipulation;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4, 5 };
		
		reverse(digits);
		ArrayUtils.printf(digits);
	}
	
	private static void reverse(int[] digits) {
		for (int i = 0; i < digits.length / 2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length - i - 1];
			digits[digits.length - i - 1] = tmp;
		}
	}
}
