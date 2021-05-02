package data;

import java.util.Arrays;

public class Ex08Array {
	public static void main(String[] args) {
		// declaration
		int[] digits2 = { 1, 2, 3 };
		int[] digits = new int[3];
		digits[0] = 10;
		digits[1] = 20;
		digits[2] = 30;
		System.out.println("length: " + digits.length);
		System.out.println("digit[1]: " + digits[1]);

		for (int i = 0; i < digits.length; i++) {
			System.out.println(digits[i]);
		}

		System.out.println(Arrays.toString(digits));
	}

}
