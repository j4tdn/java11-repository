package sorting;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex04 {
	public static void main(String[] args) {
		int[] numbers = { 5, 7, 12, 9, 10, 6, 7, 34, 19, 6 };
		int[] digits = { 5, 7, 9, 8, 6, 3, 2, 1, 10, 4 };
		System.out.println("============ Bubble Sort ==============");
		ArrayUtils.printf(bubbleSort(numbers));
		System.out.println("============ Selection Sort ==============");
		ArrayUtils.printf(selectionSort(digits));
		System.out.println("============ Inserting Sort =============");
		ArrayUtils.printf(insertingSort(numbers));
		System.out.println("============ Shell Sort =================");
		ArrayUtils.printf(shellSort(numbers));
		System.out.println("============ Merge Sort =================");
		ArrayUtils.printf(mergeSort(numbers, 0, numbers.length - 1));
	}

	private static int[] bubbleSort(int[] numbers) {
		int[] arr = Arrays.copyOfRange(numbers, 0, numbers.length);
		int tmp = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		return arr;
	}

	private static int[] selectionSort(int[] numbers) {
		int[] arr = Arrays.copyOfRange(numbers, 0, numbers.length);
		int tmp = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;

				}
			}
		}

		return arr;
	}

	private static int[] insertingSort(int[] numbers) {
		int[] arr = Arrays.copyOfRange(numbers, 0, numbers.length);
		int value;
		int pos;
		for (int i = 1; i < arr.length; i++) {
			value = arr[i];
			pos = i;
			while (pos > 0 && arr[pos - 1] > value) {
				arr[pos] = arr[pos - 1];
				pos--;
			}
			if (pos != i) {
				arr[pos] = value;
			}
		}

		return arr;
	}

	private static int[] shellSort(int[] numbers) {
		int[] arr = Arrays.copyOfRange(numbers, 0, numbers.length);
		int interval = 1;
		int value = 0;
		int j = 0;

		while (interval <= arr.length / 3) {
			interval = interval * 3 + 1;
		}
		while (interval > 0) {

			for (int i = interval; i < numbers.length; i++) {
				value = arr[i];
				j = i;
				while (j > interval - 1 && arr[j - interval] >= value) {
					arr[j] = arr[j - interval];
					j -= interval;
				}

				arr[j] = value;
			}

			interval = (interval - 1) / 3;
		}

		return arr;
	}

	private static void merge(int[] arr, int beg, int mid, int end) {
		int l = mid - beg + 1;
		int r = end - mid;

		int[] leftArr = new int[l];
		int[] righArr = new int[r];
		for (int i = 0; i < l; ++i) {
			leftArr[i] = arr[beg + i];
		}

		for (int j = 0; j < r; ++j) {
			righArr[j] = arr[mid + 1 + j];
		}

		int i = 0, j = 0;
		int k = beg;
		while (i < l && j < r) {
			if (leftArr[i] <= righArr[j]) {
				arr[k] = leftArr[i];
				i++;
			} else {
				arr[k] = righArr[j];
				j++;
			}
			k++;
		}
		while (i < l) {
			arr[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < r) {
			arr[k] = righArr[j];
			j++;
			k++;
		}
	}
	
	private static int[] mergeSort(int[] numbers, int beg, int end) {
		int[] arr = Arrays.copyOfRange(numbers, 0, numbers.length);
		if(beg < end) {
			int mid = (beg + end) / 2;
			arr = mergeSort(arr, beg, mid);
			arr = mergeSort(arr, mid + 1, end);
			merge(arr, beg, mid, end);
		}
		
		return arr;
	}
}
