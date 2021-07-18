package sorting;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = {1, 5, 9, 4, 6, 11};
		
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j+1] ) {
					int tmp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = tmp;
				}
			}
		}
		
		ArrayUtils.printf(numbers);
	}
}
