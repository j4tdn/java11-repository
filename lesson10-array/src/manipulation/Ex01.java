package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };
		System.out.println(sum(digits));

		System.out.println(getMaxMin(digits));

		int[] addDigits = add(digits, 100, 2);

		ArrayUtils.printf(addDigits);

		int[] moveDigits = remove(digits, 3);
		ArrayUtils.printf(moveDigits);
	}

	private static int sum(int[] digits) {
		int sum = 0;
		for (int digit : digits) {
			if (digit % 2 == 0) {
				sum += digit;
			}
		}
		return sum;
	}

	private static Tuple getMaxMin(int[] digits) {
		if (digits.length == 0) {
			throw new IllegalArgumentException("Digits arrays should not be empty!");
		}
		int max = digits[0];
		int min = digits[0];
		for (int digit : digits) {
			max = max < digit ? digit : max;
			min = min < digit ? min : digit;
		}
		return new Tuple(max, min);

	}

	private static int[] add(int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length + 1];
		for (int i = 0; i < pos; i++) {
			result[i] = origin[i];
		}
		result[pos] = newElement;
		for (int i = pos + 1; i < result.length; i++) {
			result[i] = origin[i - 1];
		}
		return result;
	}

	private static int[] remove(int[] origin, int pos) {
		int[] result = new int[origin.length - 1];
		for (int i = pos; i < origin.length - 1; i++) {
			origin[i] = origin[i + 1];
		}

		return Arrays.copyOfRange(origin, 0, origin.length-1);
	}

}
