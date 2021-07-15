package sorting;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		//length: 6
		int[] numbers = {1, 5,11, 9, 4, 6 };
		// i : 	0-5
		// j : 
		
		for(int i =0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length - i -1; j++) {
			//sorting ascending, descending
				if(numbers[j] < numbers[j+1]) {
					int tmp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] =  tmp;
					swap(numbers, i, j+1);
				}
			}
		}
		ArrayUtils.printf(numbers);
		
		//bubble sort: tang dan
		for (int i = numbers.length-1; i >0; i--) {
			for (int j = 0; j < i; j++) {
				if(numbers[j] > numbers[i]) {
					swap(numbers, i , j);
			}
		}
		
		
	}

		ArrayUtils.printf(numbers);
	}
	
	private static void swap(int[]a,int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
