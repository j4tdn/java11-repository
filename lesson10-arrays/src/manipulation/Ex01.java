package manipulation;

import java.util.Arrays;
import java.util.Comparator;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };
		int[] rs = add(digits, 2, 4);
		for (var s : rs) {
			System.out.println(s);
		}
	}

	private static int[] add(int[] digits, int k, int h) {
		int[] rs = new int[digits.length + 1];
		for (int i = 0; i < k; i++) {
			rs[i] = digits[i];
		}
		rs[k] = h;
		for (int i = k + 1; i < rs.length; i++) {
			rs[i] = digits[i - 1];
		}

		return rs;
	}

	private static int[] add1(int[] digits, int k, int h) {
		int[] rs = new int[digits.length + 1];

		for (int i = 0; i < rs.length; i++) {
			int j = i;
			if (i == k) {
				rs[k] = h;
				continue;
			}
			if (i > k) {

				j = j - 1;
			}
			rs[i] = digits[j];
		}
		return rs;
	}

	private static int[] insert(int[] digits, int k, int newElement) {
		int[] result = new int[digits.length + 1];
		for (int i = 0; i < digits.length; i++) {
			result[i] = digits[i];
		}
		// shift right 1 unit
		for (int j = result.length - 1; j > k; j--) {
			result[j] = result[j - 1];
		}
		result[k] = newElement;
		return result;
	}

	private static int[] remove(int[] digits, int k) {
		int[] result = new int[digits.length + 1];
		for (int i = 0; i < k; i++) {
			result[i] = digits[i];
		}
		for (int i = k + 1; i < digits.length; i++) {
			result[i - 1] = digits[i];
		}
		return digits;

	}

	private static int[] delete(int[] digits, int k) {
		for (int i = 0; i < digits.length; i++) {
			digits[i + 1] = digits[i];
		}
		return Arrays.copyOfRange(digits, 0, digits.length - 1);

	}
}
