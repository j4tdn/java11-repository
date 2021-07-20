package manipulation;


import bean.Tuple;
import static untils.ArrayUtils.*;

public class Ex01 {
	/**
	 * 	Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33};
		With k from 0 - (length-1)
		+ Calculate sum of odd numbers 
		+ Find max, min in one loop
		+ Add element at index k
		+ Remove element at index k 
		+ Update element at index k
	 */
	public static void main(String[] args) {
		int[] digits = {1, 9, 5, 36, 12, 33};
		printf(add(digits, 15, 2));
		printf(remove(digits, 2));
	}
	
	private static int sum(int[] digits) {
		int sum = 0;
		for (int digit : digits) {
			if (digit % 2 != 0) {
				sum +=digit;
			}
		}
		return sum;
	}
	
	private static Tuple getMaxMin(int[] digits) {
		if(digits.length == 0) {
			throw new IllegalArgumentException("Digits array should not be empty !");
		}
		
		int max = digits[0];
		int min = digits[0];
		for (int digit : digits) {
			if(max < digit) {
				max = digit;
			}
			if(min > digit) {
				min = digit;
			}
		}
		return new Tuple(max, min);
	}
	
	private static int[] add(int[] origin, int newElement, int pos) {
		int[] result = new int[origin.length + 1];
		
		// set value for result at index from 0 to position
		for (int i = 0; i < pos; i++) {
			result[i] = origin[i];
		}
		
		// add new element
		result[pos] = newElement;

		// set value for result at index from 0 to position
		for (int i = pos + 1; i < result.length; i++) {
			result[i] = origin[i-1];
		}
		
		return result;
	}
	
	private static int[] remove(int[] origin, int pos) {
		int[] result = new int[origin.length - 1];
		for (int i = 0; i < result.length; i++) {
			if (i < pos) {
				result[i] = origin[i];
			} else {
				result[i] = origin[i+1];
			}
		}
		return result;
	}
	
	private static int[] update(int[] origin, int newElement, int pos) {
		origin[pos] = newElement;
		return origin;
	}
	
}
