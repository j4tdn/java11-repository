package manipulation;

import java.util.Arrays;

import bean.Tuple;

public class Ex01 {
	/**
	 * Ex01: Give an array int[] = {1, 9, 5, 36, 12, 33};
     * With k from 0 - (length-1)
     * Calculate sum of odd numbers 
     * Find max, min in one loop
     * Add element to index k
     * Remove element from index k 
     * Update element at index k
	 */
	public static void main(String[] args) {
		int[] digits = {1, 9, 5, 36, 12, 33};
		int[] result1 = add(digits,100,3);
		int[] result2 = remove(digits,3);
		for(int i: result2) {
			System.out.println(i);
		}
	}
	
	private static int sum(int[] digits) {
		int sum = 0;
		for(int i: digits) {
			if(i % 2 ==0) {
				sum += i;
			}
		}
		return sum;
	}
	private Tuple max(int[] digits) {
		
		if(digits.length == 0) {
			throw new IllegalArgumentException("Digits array should not be empty! ");
		}
		int min = digits[0];
		int max = digits[0];
		for(int digit : digits) {
			if(max < digit) {
				max = digit;
			}
			if(min > digit) {
				min  =digit;
			}
		}
		return new Tuple(max,min);
	}
	private static int[] add(int[] digits,int newElement,  int k) {
		int[] result = new int[digits.length + 1];
		for(int i = digits.length; i > k; i--) {
			result[i] = digits[i-1];
		}
		result[k] = newElement;
		for(int i = k-1; i >=0; i--) {
			result[i] = digits[i];
		}
		return result;
	}
	private static int[] remove(int[] digits, int pos) {
	  int [] temp = Arrays.copyOfRange(digits, 0, digits.length);
		for(int i = pos; i< temp.length -1; i++) {
			temp[i] = temp[i+1];
		}
		return Arrays.copyOfRange(temp, 0, temp.length-1);
	}
	

}
