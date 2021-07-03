package declaration;

import java.util.Arrays;

import function.Condition;
import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = { 3, 6, 5, 7, 12, 9, 4 };

		Condition c = x -> x % 2 != 0;
		
		// get odd elements in digits
		int[] oddElements = getOdd(digits, c);
		ArrayUtils.printf(oddElements);
		
		System.out.println();
		
		int[] evenElements = getOdd(digits, y -> y % 2 == 0);
		ArrayUtils.printf(evenElements);
	}

	private static int[] getOdd(int[] digits, Condition condition) {
		int[] results = new int[digits.length];
		int index = 0;
		
		for (int digit : digits) {
			if (condition.test(digit)) {
				results[index++] = digit;
			}
		}

		System.out.println("index: " + index);
		return Arrays.copyOfRange(results, 0, index);
	}
}
