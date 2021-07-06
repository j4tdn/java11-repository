package manupulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	/**
	 * Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33}; With k from 0 - (length-1)
	 * + Calculate sum of odd numbers + Find max, min in one loop + Add element to
	 * index k + Remove element from index k + Update element at index k
	 */
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };
		
		int[] inserted = add(digits, 236, 4);
		ArrayUtils.printf(inserted);
		
		int[] removed = remove(digits, 3);
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

	private static Tuple getMaxMin(int[] digits) {
		if (digits.length == 0) {
			throw new IllegalArgumentException("Digits arra");
		}
		int max = digits[0];
		int min = digits[0];
		for (int digit : digits) {
			if (max < digit) {
				max = digit;
			}
			if (min < digit) {
				min = digit;
			}
		}
		return new Tuple(max, min);
	}
	
		// shift right: loop from RIGHT to LEFT
		//       left :           LEFT     RIGHT
		// pos = 2 >< newElement = 15
		// 1, 9, 5, 36, 12, 33      origin
		// 1, 9, 5, 36, 12, 33, 0   B1: copy
		// 1, 9, 5,  5, 36, 12, 33  B2: shift right one unit
		// 1, 9, 15, 5, 36, 12, 33  expected result
	private static int[] add(int[] orgin, int newElement, int pos) {
		int[] result = new int[orgin.length+1];
		//copy
		for (int i = 0; i < orgin.length; i++) {
			result[i] = orgin[i];
		}
		//shift right one unit
		
		for (int i = result.length-1; i > pos; i--) {
			result[i] = result[i-1];
		}
		//assign newElement
		result[pos] = newElement;
		return result;
	}
	
	
	// 1, 9, 5, 36, 12, 33
	// 1, 9, 5, 36, 12, 33, 33
	// 1, 9, 36, 12, 33 (remove pos 2)
	private static int[] remove(int[] origin, int pos) {
		int[] tmp = Arrays.copyOfRange(origin, pos, pos);
		for (int i = pos; i < origin.length-1; i++) {
			tmp[i] = tmp[i+1];	
		}
		return Arrays.copyOfRange(tmp, 0, tmp.length-1);
	}
	
	
}