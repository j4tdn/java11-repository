package declaration;


import java.util.Arrays;
import function.Predicate;
import  utils.ArrayUtils;

public class Ex02  {
	public static void main(String[] args) {
		int[] digit = {1,2,3,4,5,6,7,8,9,10};
		
		int[] evenElement = getElement(digit, a -> a % 2 == 0);
		int[] oddElement = getElement(digit, a -> a % 2 != 0);
		int[] powerOf3 = getElement(digit, a -> a % 3 == 0);

		ArrayUtils.printf(evenElement);
		ArrayUtils.printf(oddElement);
		ArrayUtils.printf(powerOf3);
	}
	
	
	private static int[] getElement(int[] digits, Predicate predicate) {
		int[] result = new int[digits.length];
		int index = 0;
		for(int i = 0; i < digits.length; i++) {
			if(predicate.test(digits[i])) {
				result[index++] = digits[i];
			}
		}
		
		return Arrays.copyOfRange(result, 0, index);
	}

	
	
}
