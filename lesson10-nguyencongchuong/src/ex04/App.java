package ex04;

public class App {
	public static void main(String[] args) {
		int[] digits = { 2, 14, 56, 47, 32, 18, 33, 86, 85, 67 };

		bubbleSort(digits);
		System.out.println("Bubble Sort: ");
		print(digits);
		
		selectionSort(digits);
		System.out.println("\nSelection Sort: ");
		print(digits);
		
		insertionsort(digits);
		System.out.println("\nInsertion Sort: ");
		print(digits);

	}

	private static int[] bubbleSort(int[] digits) {
		int[] results = new int[digits.length];

		for (int i = 0; i < digits.length; i++) {
			boolean swap = false;
			for (int j = 0; j < digits.length - i - 1; j++) {
				if (digits[j] > digits[j + 1]) {
					int temp = digits[j];
					digits[j] = digits[j + 1];
					digits[j + 1] = temp;
					swap = true;
				}
			}
			if (swap == false) {
				break;
			}
		}
		results = digits;
		return results;
	}
	
	private static int[] selectionSort(int[] digits) {
		int[] result = new int[digits.length];
		
		for(int i = 0; i < digits.length; i++) {
			int min = i;
			for(int j = i + 1; j < digits.length; j++) {
				if(digits[j] < digits[min]) {
					min = j;
					int temp = digits[min];
					digits[min] = digits[i];
					digits[i] = temp;
				}
			}
			result = digits;
		}
		
		return result;
	}
	
	private static int[] insertionsort(int[] digits) {
		int[] result = new int[digits.length];
		
		for(int i = 1; i < digits.length; i++) {
			int key = digits[i];
			int j = i - 1;
			
			while(j >= 0 && digits[j] > digits[j + 1]) {
				digits[j + 1] = digits[j];
//				j = j - 1;
			}
			digits[++j] = key;
		}
		result = digits;
		return result;
	}

	private static void print(int[] digits) {
		for (int digit : digits) {
			System.out.print(digit + " ");
		}
	}
}
