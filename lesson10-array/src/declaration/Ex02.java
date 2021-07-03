package declaration;

import java.util.Arrays;

import fuction.Predicate;
import utils.ArrayUtils;


public class Ex02 {
	public static void main(String[] args) {
		int[]digits  = {1, 4, 7, 3, 12};
		
		Predicate pre = x-> x % 2 == 0;
		
		int[] oddElements = getElements(digits, pre);
		ArrayUtils.printf(oddElements);
		int[] powerOf3 = getElements(digits, x-> x%3 ==0);
		//get odd elements in digits 
		
		ArrayUtils.printf(powerOf3);
		
	}
		
	private static int[] getElements(int[]digits, Predicate predicate) {
		//fix-length
		int run = 0;
		int[] result = new int[digits.length];
		for (int digit: digits) {
			if(predicate.test(digit)) {
				result[run] = digit;
				run++;
			}
		}
		//0 0 0 0 0 0 
		//1 7 3 9
		//System.out.println("run: " + run);
		
		return Arrays.copyOfRange(result, 0, run);
	}
}

