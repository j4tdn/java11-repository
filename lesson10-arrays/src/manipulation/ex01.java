package manipulation;

import utils.ArrayUtils;

public class ex01 {
	public static void main(String[] args) {
		int[] digits = {1, 9, 5, 36, 12, 33};
		ArrayUtils.printf(add(digits, 2, 77));
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
			result[k] = digits[i-1];
		}
		
		return result;
	}
}
