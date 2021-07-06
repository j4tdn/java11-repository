package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	/**
	 * Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33}; > With k from 0 -
	 * (length-1) + Calculate sum of odd numbers + Find max, min in one loop + Add
	 * element to index k + Remove element from index k + Update element at index k
	 */
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };
		ArrayUtils.printf(digits);

		int[] a = add(digits, 15, 5);
		ArrayUtils.printf(a);

		int[] remove = remove(digits, 4);
		ArrayUtils.printf(remove);
	}

	private static int getSumOdd(int[] arrays) {
		int result = 0;
		for (int element : arrays) {
			if (element % 2 != 0) {
				result += element;
			}
		}
		return result;
	}

	private static Tuple getMaxMin(int[] arrays) {
		if (arrays.length == 0) {
			throw new IllegalArgumentException("Digits arrays shold not be empty!");
		}
		int max = arrays[0];
		int min = arrays[0];
		for (int element : arrays) {
			if (max < element) {
				max = element;
			}
			if (min > element) {
				min = element;
			}
		}
		return new Tuple(max, min);
	}

	// shift right: loop from RIGHT to LEFT
	// left : LEFT RIGHT
	// pos = 2 >< newElement = 15
	// 1, 9, 5, 36, 12, 33 origin
	// 1, 9, 5, 36, 12, 33, 0 B1: copy
	// 1, 9, 5, 5, 36, 12, 33 B2: shift right one unit
	// 1, 9, 15, 5, 36, 12, 33 expected result
	private static int[] add(int[] origin, int element, int pos) {
		int[] results = new int[origin.length + 1];
		for (int i = 0; i < results.length; i++) {
			if (i == pos) {
				results[pos] = element;
				continue;
			}
			if (i < pos) {
				results[i] = origin[i];
			} else {
				results[i] = origin[i - 1];
			}
		}
		return results;
	}

	private static int[] remove(int[] origin, int pos) {
		int[] tmp = Arrays.copyOfRange(origin, 0, origin.length);
		
		for (int i = pos; i < origin.length - 1; i++) {
			tmp[i] = tmp[i + 1];
		}

		return Arrays.copyOfRange(origin, 0, origin.length - 1);
	}

}
