package ex01;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		 int[] array = {1, 9, 5, 5, 6, 10, 12, 8, 2, 10, 9, 8, 7, 11};
		 int[] filter = filter(array);
		 ArrayUtils.printf(filter);
		 System.out.println(compareAverage(array));
		 System.out.println(get3thMax(array));	 

	}
	
	public static int[] filter(int[] digits) {
		int[] filters = new int[digits.length];
		int index = 0;
		for(int digit : digits) {
			int count = 0;
			for(int digit2:digits) {
				if(digit2 == digit) {
					count++;
				}
			}
			if(count == 1) {
				filters[index++] = digit;
			}
		}
		return Arrays.copyOfRange(filters, 0, index);
		
	}
	private static boolean compareAverage(int[] digits) {
		double sum1 = 0, sum2 = 0;
		int count1 = 0, count2 = 0;
		for (int i = 0; i < digits.length/2; i++) {
			sum1 += digits[i];
			count1++;
		}
		double average1 = sum1/count1;
		for (int i = digits.length/2 ; i < digits.length; i++) {
			sum2 += digits[i];
			count2++;
		}
		double average2 = sum2/count2;

		if(average1 >= average2) {
			return true;
		}
		return false;
	}
	private static int[] sort(int a[]){
		for (int i = a.length-1; i >= 1; i--){
			boolean swapped= true;
			for (int j = 0; j < i; j++){
				if (a[j] > a[j+1]){
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swapped = false;
				}
			}
			if (swapped){
				break;
			}
		}
		return a;
	}
	private static int get3thMax(int digits[]) {
		int n = digits.length;
		int[] a = Arrays.copyOfRange(digits, 0, n);
		for (int i = 0; i < n - 1; i++)
		{
	    	int j = i + 1;
	    	while (j < n)
	    	if (a[i] == a[j])
			  {
	        	for (int k = j; k < n-1; k++) 
					a[k] = a[k+1];
	    	        n = n - 1;
	    	    }
	         else j = j + 1;
	     }
		return sort(Arrays.copyOfRange(a, 0, n))[n-3];
	}


}
