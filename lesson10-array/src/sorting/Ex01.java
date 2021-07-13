package sorting;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = {1 ,5 ,7, 6, 8,3};
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length - 1 - i; j++) {
				if(numbers[j] < numbers[j+1]) {
					swap(numbers,j,j+1);

				}
			}
		}
		ArrayUtils.printf(numbers);
		for(int i = numbers.length-1 ; i> 0; i--) {
			for(int j = 0; j < i; j++) {
				if(numbers[j] > numbers[i]) {
					swap(numbers,j, i);
				}
			}
		}
		ArrayUtils.printf(numbers);
	}
	private static void swap(int[] a,int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
