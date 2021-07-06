package mainipulation;

import java.util.Arrays;
import java.util.Iterator;

import bean.Tuple;

public class Ex01 {
	/**
	 * Calculate sum of odd numbers + Find max, min in one loop + Add element to
	 * index k + Remove element from index k + Update element at index k + Sort
	 * array using . bubble/insertion/selection algorithm
	 */
	public static void main(String[] args) {
		int[] digits = { 1, 9, 5, 36, 12, 33 };

		int[] inserted = add(digits, 15, 2);
		for (int i : inserted) {
			System.out.print(i + " ");
		}
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
			throw new IllegalArgumentException("digits arrays should not be empty !");
		}
		int max = digits[0];
		int min = digits[0];

		for (int i : digits) {
			if (i > max) {
				i = max;
			}
			if (i < min) {
				i = min;
			}
		}
		return new Tuple(max, min);
	}
// shift right: loop from RIGHT to LEFT
	private static int[] add(int[] origin, int newElement, int pos) {

		int[] result = new int[origin.length + 1];

		for (int i = 0; i < pos; i++) {
			result[i] = origin[i];
		}
		result[pos] = newElement;
		for (int i = pos; i < origin.length; i++) {
			result[i + 1] = origin[i];
		}
		return result;
	}
	private static int[] remove(int[] origin,  int pos) {

		int[] result = new int[origin.length - 1];

		for (int i = 0; i < origin.length; i++) {
			if(i<pos) {
				result[i]=origin[i];
			}
			if(i>pos) {
				result[i - 1]=origin[i];
			}
			
		}
		
		return result;
	}
	private static int[] remove1(int[] origin,  int pos) {
		for(int i = pos; i< origin.length-1; i++) {
			origin[i] = origin[i+1];
		}
		
		return Arrays.copyOfRange(origin, 0, origin.length -1);
	}

	
}
