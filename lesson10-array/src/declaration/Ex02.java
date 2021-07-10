package declaration;

import java.util.Arrays;

import function.Predicate;
import utils.ArrayUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = {1, 4, 6, 7, 5};
		//Predicate pre = new Predicate() {
		//	
		//	@Override
		//	public boolean test(int a) {
		//		return a % 2==0;
		//	}
		//};
		
		//Predicate pre1 = x -> x % 2 != 0; 
		int[] oddElement = getElements(digits, x -> x % 2 != 0);
		//int[] powerOf3 = getElements(digits, x -> x % 3 == 0);

		ArrayUtils.printf(oddElement);
		//get odd elements in digits
	}
	private static int[] getElements(int[] digits, Predicate predicate) {
		
		int count = 0;
		int [] result = new int[digits.length];
		for(int digit: digits) {
			if(predicate.test(digit)) {
				result[count++] = digit;
				
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
	
}