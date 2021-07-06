package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	/**
	 Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33};
    With k from 0 - (length-1)
    + Calculate sum of odd numbers 
    + Find max, min in one loop
    + Add element at index k
    + Remove element from index k 
    + Update element at index k
	 */
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };
		
		int[] inserted = add(digits, 195, 2);
		ArrayUtils.printf(inserted);
		
		int[] removed = remove(digits, 2);
		ArrayUtils.printf(removed);
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

	private static Tuple maxmin(int[] digits) {
		if (digits.length == 0) {
			throw new IllegalArgumentException("Digits arrays should not be empty !");
		}
		int max = digits[0];
		int min = digits[0];
		for (int digit : digits) {
			if (digit > max) {
				max = digit;
			}
			if (digit < min) {
				min = digit;
			}
		}
		return new Tuple(max, min);
	}
	
	private static int[] add (int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length + 1];
		
		for (int i = 0; i < pos; i++) {
			result[i] = origin[i];
		}
		result[pos] = newElement;
		for(int i = pos; i < origin.length; i++) {
			result[i+1] = origin[i];
		}
		return result;
	}
	
	private static int[] remove (int[] origin, int pos) {
		
		int[] tmp = Arrays.copyOfRange(origin, 0, origin.length);
		
		for (int i = pos; i < tmp.length-1; i++) {
			tmp[i] = tmp[i+1];
		}
		return Arrays.copyOfRange(tmp, 0, tmp.length-1);
	}
}
