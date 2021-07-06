package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		/**
		Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33};
        With k from 0 - (length-1)
         + Calculate sum of odd numbers 
         + Find max, min in one loop
         + Add element to index k
         + Remove element from index k 
         + Update element at index k
		 */
		 int[] array = {1, 9, 5, 36, 12, 33};
		 System.out.println(sum(array));
		 System.out.println(getMaxMin(array));
		 int[] inserted = add(array, 7, 3);
		 ArrayUtils.printf(inserted);
		 int[] removed = remove(array,4);
		 ArrayUtils.printf(removed);
		 
	}
	private static int sum(int[] digits) {
		int sum = 0;
		for(int digit : digits) {
			if(digit % 2 != 0) {
				sum += digit;
			}
		}
		return sum;
	}
	private static Tuple getMaxMin(int[] digits) {
		if(digits.length == 0) {
			throw new IllegalArgumentException("Digits array should not be empty!");
		}
		int max = digits[0];
		int min = digits[0];
		for(int digit : digits) {
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

		for(int i = 0; i < pos; i++) {
			result[i] = origin[i];
		}
		result[pos] = newElement;
		for(int i = pos+1; i < result.length; i++ ) {
			result[i] = origin[i-1];
		}
		return result;
	}
	private static int[] remove(int[] origin, int pos ) {
		int[] tmp = Arrays.copyOfRange(origin, 0, origin.length);
		for(int i = pos; i < origin.length - 1; i++) {
			tmp[i] = tmp[i+1];
		}
		return Arrays.copyOfRange(tmp, 0, origin.length-1);
	}
	private static void reverse(int[] digits) {
		for (int i = 0; i < digits.length/2; i++) {
			int tmp = digits[i];
			digits[i] = digits[digits.length-1-i];
			digits[digits.length-1-i] = tmp; 
		}
	}
}
