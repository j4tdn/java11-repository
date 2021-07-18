package manipulation;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = {1, 9, 5, 36, 12, 33};
		ArrayUtils.printf(insert(digits, 2, 77));
		System.out.println();
		ArrayUtils.printf(remove(digits, 2));
		System.out.println();
		ArrayUtils.printf(delete(digits, 2));

	}
	
	// 1 9 5 36 12 33
	// k = 2, newElement = 77;
	// 1 9 77 5 36 12 33
	private static int[] add(int[] digits, int k, int newElement) {
		int[] result = new int[digits.length+1];
		for(int i = 0; i<k; i++) {
			result[i] = digits[i];
		}
		
		result[k] = newElement;
		
		for(int i = k + 1; i < result.length; i++) {
			result[i] = digits[i-1];
		}
		
		return result;
	}
	
	private static int[] insert(int[] digits, int k, int newElement) {
		int[] result = new int[digits.length+1];
		for (int i = 0; i < digits.length; i++) {
			result[i] = digits[i];
		}
		
		for(int i = digits.length; i > k; i--) {
			result[i] = result[i-1];
		}
		result[k] = newElement;
		return result;
	}
	
	private static int[] remove(int[] digits, int k) {
		int[] result = new int[digits.length-1];
		
		for(int i = 0; i < k; i++) {
			result[i] = digits[i];
		}
		for(int i = k; i < digits.length-1; i++) {
			result[i] = digits[i+1];
		}
		
		return result;
	}
	
	private static int[] delete(int[] digits, int k) {
		for(int i = k+1; i< digits.length; i++) {
			digits[i-1] = digits[i];
		}
		return Arrays.copyOfRange(digits, 0, digits.length-1);
	}
}
