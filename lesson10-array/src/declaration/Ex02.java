package declaration;

import java.util.Arrays;

import function.Predicate;

import static utils.ArrayUtils.*;

public class Ex02 {
	public static void main(String[] args) {
		int[] digits = {1, 4, 7, 3, 12, 9};
	 
		// get odd element in digits
		int[] oddElements = getElements(digits, x -> x % 2 != 0);
		int[] powerOf3 = getElements(digits, x -> x % 3 == 0);
		printf(oddElements); // Khi cần gọi nhiều hàm như này mới gọi
		printf(powerOf3);
	}
	
	// generic type: T
	private static int[] getElements(int[] digits, Predicate predicate) {
		// fixed-length
		// should assign max containable length
		int[] result = new int[digits.length];
		int run = 0;
		for (int digit: digits) {
			if (predicate.test(digit)) {
				if (digit % 2 != 0) {
					result[run++] = digit;
				}
			}
		}
		return Arrays.copyOfRange(result, 0, run);
	}
}
