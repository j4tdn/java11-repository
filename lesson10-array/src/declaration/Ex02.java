package declaration;

import java.util.Arrays;

import function.Predicate;

import static untils.ArrayUtils.*;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = { 1, 4, 7, 3, 12 };
		int[] oddElements = getElements(digits, x -> x % 2 != 0);
		int[] powerOf3Elements = getElements(digits, x -> (x % 3 == 0));
		printf(oddElements);
		printf(powerOf3Elements);
	}

	private static int[] getElements(int[] digits, Predicate predicate) {
		int[] result = new int[digits.length];
		int run = 0;
		for (var digit : digits) {
			if (predicate.test(digit)) {
				result[run++] = digit;
			}
		}
		return Arrays.copyOfRange(result, 0, run);
	}
}
