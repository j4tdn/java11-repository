package mainipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	/**
	 Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33};
	> With k from 0 - (length-1)
	+ Calculate sum of odd numbers 
	+ Find max, min in one loop
	+ Add element to index k
	+ Remove element from index k 
	+ Update element at index k
	 */
	public static void main(String[] args) {
		int[] digits = {1,9,5,36,12,33};
		
		int[] inserted = add(digits, 15, 2);
		ArrayUtils.printf(inserted);
		
		int[] remove = remove(inserted, 3);
		ArrayUtils.printf(remove);
	}
	
	private static int sum(int[] digits) {
		int sum = 0;
		for(int digit: digits) {
			if(digit % 2 != 0) {
				sum += digit;
			}
		}
		return sum;
	}
	
	private static Tuple getMaxMin(int[] digits) {
		if(digits.length == 0) {
			throw new IllegalArgumentException("Digits arrays should not be empty !");
		}
		int max = digits[0];
		int min = digits[0];
		for(int digit: digits) {
			if(max < digit) {
				max = digit;
			}
			if(min > digit) {
				min = digit;
			}
		}
		return new Tuple (max, min);
	}
	// shift right: loop from RIGHT to LEFT
	//     	 left : 		  LEFT	   RIGHT
	// pos = 2 >< newElement = 15
	// 1, 9, 5, 36, 12, 33        origin
	// 1, 9, 5, 36, 12, 33, 0     B1: origin
	// 1, 9, 5, 5, 36, 12, 33, 0  B2: shift right on unit
	
	// 1, 9, 15, 5, 36, 12, 33  expected result
	private static int[] add(int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length + 1];
		
		// copy
		for(int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}
		
		// shift right one unit
		for(int i = result.length-1; i > pos; i--) {
			result[i] = result[i-1];
		}
		
		// assign newElement
		result[pos] = newElement;
		return result;
	}
	
	private static int[] remove(int[] origin, int pos) {
		int[] tmp = Arrays.copyOfRange(origin, 0, origin.length-1);
		for (int i = pos; i < origin.length-1; i++) {
			tmp[i] = origin[i+1];
		}
		return Arrays.copyOfRange(tmp, 0, tmp.length-1);
	}
}
