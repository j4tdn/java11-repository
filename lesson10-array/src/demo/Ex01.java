package demo;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 1, 5, 9, 1000, 12, 4, 6, 11 };
		quickSort(numbers, 0, numbers.length);
		ArrayUtils.printf(numbers);
	}

	// Bubble Sort
	private static void bubbleSort(int[] numbers) {
		int tmp;
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 1; j < numbers.length - i; j++) {
				if (numbers[j - 1] > numbers[j]) {
					tmp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = tmp;
				}
			}
		}
	}

	// Quick Sort
	private static void quickSort(int[] numbers, int low, int high) {
		if (low < high) {
			int pi = partition(numbers, low, high);
			quickSort(numbers, low, pi - 1);
			quickSort(numbers, pi + 1, high);
		}
	}

	private static int partition(int[] numbers, int low, int high) {
		int pivot = numbers[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (numbers[j] <= pivot) {
				i++;

				int tmp = numbers[i];
				numbers[i] = numbers[j];
				numbers[j] = tmp;
			}
		}

		int tmp = numbers[i + 1];
		numbers[i + 1] = numbers[high];
		numbers[high] = tmp;

		return i + 1;
	}
	
	// Insertion Sort
	private static void InsertionSort(int[] numbers) {
		int n = numbers.length;
		for (int i = 1; i < n; i++) {
			int key = numbers[i];
			int j = i - 1;
			
			while (j >= 0 && numbers[j] > key) {
				numbers[j + 1] = numbers[j];
				j = j - 1;
			}
			numbers[j + 1] = key;
		}
	}
	
	// Selection Sort
	private static void SelectionSort(int[] numbers) {
		int n = numbers.length;
		for (int i = 0; i < n-1; i++) {
			int min_idx = i;
			for ( int j = i + 1; j < n; j++) {
				if (numbers[j] < numbers[min_idx])
					min_idx = j;
			}
			// Swap
			int tmp = numbers[min_idx];
			numbers[min_idx] = numbers[i];
			numbers[i] = tmp;
		}
		
	}
}
