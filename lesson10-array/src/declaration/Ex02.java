package declaration;

import java.util.Arrays;

import function.Predicate;
import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = {1, 2, 7, 3, 12, 25};
		
		
		//get odd elements 
		int[] oddElements = getElement(digits, x -> x % 2 != 0);
		int[] powerOf3 = getElement(digits, x -> x % 3 == 0);
		
		ArrayUtils.printf(oddElements);
		ArrayUtils.printf(powerOf3);
	}
	
	private static int[] getElement(int[] digits, Predicate predicate) {
		int[] result = new int[digits.length];
		int run = 0;
		for (int digit : digits) {
			if(predicate.test(run)) {
				result[run++] = digit;
			}
		}
		return Arrays.copyOfRange(result, 0, run);
	}
}
