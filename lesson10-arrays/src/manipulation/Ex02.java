package manipulation;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {1, 2, 3, 4, 5, 6};
		
		//Arrays.sort(a, (o1, o2) -> o2 - o1);
		ArrayUtils.printf(reverse(a));
	}
	
	private static int[] reverse(int[] digits) {
		for(int i = 0; i < digits.length/2; i++) {
			int temp = digits[i];
			digits[i] = digits[digits.length - 1 - i];
			digits[digits.length - 1 - i] = temp;
		}
		return digits;
	}
}
