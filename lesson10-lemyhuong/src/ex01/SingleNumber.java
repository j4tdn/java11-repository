package ex01;

import java.util.Arrays;

import utils.ArrayUtils;
import utils.Swap;

public class SingleNumber {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 3, 1 };
		int[] singleNumbers = getSingleNumber(numbers);
		
		ArrayUtils.printf(singleNumbers);
	}
	
	private static int[] getSingleNumber(int [] array) {
		int[] result = new int [array.length];
		boolean[] isDupNumber = new boolean[array.length];
		
		for (int out = 0; out < array.length; out ++) {
			for (int in = 0; in < array.length; in ++) {
				if (!isDupNumber[out]) {
					if (out != in && array[out] == array[in]) {
						isDupNumber[out] = true;
						isDupNumber[in] = true;
					}
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (!isDupNumber[i]) {
				result[count] = array[i];
				count++;
			}
			
		}
		
		return Arrays.copyOfRange(result, 0, count);
	}
}
