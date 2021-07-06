package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = {1, 9, 5, 36, 12, 33};
		
		ArrayUtils.printf(add(digits, 32, 2));
		ArrayUtils.printf(remove(digits,3));
	}
	
	private static int sum(int[] digits) {
		int sum = 0;
		
		for (int digit: digits) {
			if (digit % 2 != 0) {
				sum += digit;
			}
		}
		
		return sum;
	}
	
	private static Tuple getMaxMin(int[] digits) {
		if (digits.length == 0) {
			throw new IllegalArgumentException("Digits arrays should not be empty");
		}
		
		int max = digits[0];
		int min = digits[0];
		
		for (int digit: digits) {
			if (max < digit) {
				max = digit;
			}
			if (min > digit) {
				min = digit;
			}
		}
		
		return new Tuple(max, min);
		
 	}
	
	private static int[] add(int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length+1];
		
		for (int i = 0; i < origin.length; i++ ) {
			result[i] = origin[i];
		}
		
		for (int i = 0; i < result.length; i++ ) {
			result[i] = result[i-1];
		}	
     	result[pos] = newElement;
		return result;
	}
	
	private static int[] remove(int[] origin, int pos) {
		for (int i = pos; i < origin.length - 1; i++ ) {
			origin[i] = origin[i+1];
		}
		return Arrays.copyOfRange(origin, 0, origin.length-1);
	}
}
