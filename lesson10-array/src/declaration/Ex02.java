package declaration;

import java.util.Arrays;

import function.Predicate;
import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = { 1, 4, 7, 3, 12 };

//		Predicate pre = (int x) -> {
//			return x % 2 == 0;
//		};

		// get odd element in digits
		int[] oddElements = getElements(digits, x -> x % 2 != 0);
		int[] powerOf3 = getElements(digits, x -> x % 3 == 0);

		ArrayUtils.printf(oddElements);
		ArrayUtils.printf(powerOf3);

	}

	private static int[] getElements(int[] digits, Predicate predicate) {
		// fixed-length
		// should assign max containable length
		int[] result = new int[digits.length];
		int run = 0;
		for (int digit : digits) {
			if (predicate.test(digit)) {
				result[run++] = digit;
			}
		}

		// 0 0 0 0
		// 1 7 3
		System.out.println("run: " + run);
		return Arrays.copyOfRange(result, 0, run);
	}

}
