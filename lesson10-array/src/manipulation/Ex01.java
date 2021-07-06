package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };

		int[] removed = remove(digits, 2);

		ArrayUtils.printf(removed);
	}

	private static int sum(int[] digits) {
		int sum = 0;
		for (int digit : digits) {
			if (digit % 2 != 0) {
				sum += digit;
			}
		}
		return sum;
	}

	private static Tuple maxmin(int[] digits) {
		if (digits.length == 0) {
			throw new IllegalArgumentException("Digits arrays should not be empty !");
		}
		int max = digits[0];
		int min = digits[0];
		for (int digit : digits) {
			if (max < digit) {
				max = digit;
			}
			if (min > digit) {
				min = digit;
			}
		}
		return new Tuple(max, min);
	}

	// shift right: loop from Right to Left
	// || Left to Right
	// pos = 2 >< k = 15
	// 1, 9, 5, 35, 12, 33
	// 1, 9, 15, 5, 36, 12, 33
	private static int[] add(int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length + 1];

//		for (int i = 0; i < pos; i++) {
//			result[i] = origin[i];
//		}
//		
//		result[pos] = newElement;
//		
//		for (int i = pos; i < origin.length; i++) {
//			result[i + 1] = origin[i];
//		}

		// step 2: copy
		for (int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}

		// shift right one unit
		for (int i = result.length - 1; i > pos; i--) {
			result[i] = result[i - 1];
		}
		result[pos] = newElement;
		return result;
	}

	// Remove
	private static int[] remove(int[] origin, int pos) {
		/*
		 * int[] result = new int[origin.length - 1];
		 * 
		 * for (int i = 0; i < origin.length; i++) { if (i < pos + 1) { result[i] =
		 * origin[i]; } else { result[i - 1 ] = origin[i]; } }
		 * 
		 * return result;
		 */

		for (int i = pos; i < origin.length - 1; i++) {
			origin[i] = origin[i + 1];
		}
		return Arrays.copyOfRange(origin, 0, origin.length - 1);
	}

}
