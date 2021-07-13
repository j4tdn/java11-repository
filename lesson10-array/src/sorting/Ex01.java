package sorting;

import java.util.Iterator;



import utils.ArrayUtils;

public class Ex01 {
	/*
	 * bubble sort : sap xep noi bo quick sort: chia nho de tri phan tu chot
	 */
	public static void main(String[] args) {
		// length = 6
		int[] numbers = { 1, 5, 9, 4, 6, 11 };
		// i:0 - 5
		// j :0
		
		
         //bubble sort
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if(numbers[j] < numbers[j+1]) {			
//					int temp =numbers[j];
//					numbers[j] = numbers[j+1];
//					numbers[j + 1] = temp;
					swap(numbers, j, j+1);
				}

			}
		}
		ArrayUtils.printf(numbers);
		
		//bubble sort
		for(int i = numbers.length-1; i > 0; i--) {
			for(int j =0; j<i; j++) {
				if(numbers[i] < numbers[j]) {
//					int temp =numbers[i];
//					numbers[i] = numbers[j];
//					numbers[j] = temp;
					swap(numbers, j,i);
				}
			}
		}
		ArrayUtils.printf(numbers);

	}
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i]= a[j];
		a[j] = tmp;
	}

}
