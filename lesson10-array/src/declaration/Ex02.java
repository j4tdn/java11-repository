package declaration;

import java.util.Arrays;
import java.util.function.Predicate;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = {1, 4, 7, 3, 12};
	
		int[] oddElements = getElements(digits, x -> x % 2 != 0);
		
		ArrayUtils.printf(oddElements);
	}
	
	private static int[] getElements(int[] digits, Predicate predicate) {
		int[] results = new int[digits.length];
		int run = 0;
		
		for(int digit: digits) {
			if (predicate.test(digit)) {
				results[run++] = digit;
			}
		}
		
		return Arrays.copyOfRange(results, 0, run);
	}
}
