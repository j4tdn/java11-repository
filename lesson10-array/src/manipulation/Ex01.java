package manipulation;

import java.util.Arrays;

import bean.Tuple;
import utils.ArrayUtils;

public class Ex01 {
	/**
	 *Ex01: Give an int[] = {1, 9, 5, 36, 12, 33};
	With k from 0 - length-1
	+ Calculate sum of odd numbers 
	+ Find max, min in one loop
	+ Add element to index k
	+ Remove element from index k 
	+ Update element at index k
	+ Sort array using
  . bubble/insertion/selection algorithm
	 * 
	 */
	public static void main(String[] args) {
		int[]digits = {1,9,5,36,12,33};
		
		int[] inserted = add(digits, 20, 3);
		
		ArrayUtils.printf(inserted);
		
		int[] deleted = remove(digits, 1);
		ArrayUtils.printf(deleted);
	
		update(digits, 1, 18);
		ArrayUtils.printf(digits);
	}
	
	
	private static int sum(int[] digits) {
		int sum = 0;
		for(int digit:digits) {
			if(digit % 2 !=0) {
				sum += digit;
			}
		}
		return sum;
	}
	
	private static Tuple getMaxMin(int[] digits) {
		if(digits.length ==0) {
			throw new IllegalArgumentException("Digits array should not empty!");
		}
		int max = digits[0];
		int min = digits[0];
		for(int digit :digits) {
			if(max < digit) {
				max = digit;
			}
			if(min > digit ) {
				min = digit;
			}
		}
		return new Tuple(max, min);
	}
	
	private static int[] add(int[] origin, int newElement, int pos) {
		//pos = 2 >< new Element =15
		//shift right: duyet tu PHAI sang TRAI
		//shift left: duyen tu TRAI sang PHAI
		//pos = 2 >< newElement = 15
		//1, 9, 5, 36, 12, 33 : origin
		//1, 9, 5, 36, 12, 33, 0 : B1 copy
		//1, 9, 5, 5 , 36, 12, 33  B2 shift right one unit
		
		//1, 9, 15, 5 , 36, 12, 33 expected result
		
		
		int[]result = new int[origin.length +1];
//		
//		for(int i =0; i<pos; i++) {
//			result[i] = origin[i];
//		}
//		result[pos] = newElement;
//		for(int i =pos; i<origin.length; i++) {
//			result[i+1] = origin[i];
//		}
//		return result;
		
		//copy
		for (int i = 0; i < origin.length; i++) {
			result[i] = origin[i];
		}
		
		//shift right one 
		for (int i = result.length-1; i >pos; i--) {
			result[i] = result[i-1];
	
		}
		//assign element
		result[pos] =newElement;
		return result;
	}
	
	//1 9 5 20 36 12 33 
	//1 9 20 36 12 33  (remove pos 2)
	private static int[] remove(int[] origin,int pos) {
//		int[] result = new int[origin.length -1];
//		for (int i = 0; i < origin.length; i++) {
//			if(i < pos) {
//				result[i] = origin[i];
//			}else if(i> pos) {
//				result[i-1] = origin[i];
//			}
//		}
//		return result;
		int[] tmp = Arrays.copyOfRange(origin, 0, origin.length);
		for (int i = 0; i < origin.length-1; i++) {
			tmp[i] =tmp[i+1];
		}
		return Arrays.copyOfRange(tmp, 0, tmp.length-1);
	}
	
	private static void update(int[] origin, int pos, int Element) {
		for (int i = 0; i < origin.length; i++) {
			if(i == pos) {
				origin[i] = Element;
			}
		}
	}
}
