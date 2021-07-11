package sorting;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		int[] digit = { 33, 55, 44, 66, 88, 11, 77 };

		Student[] students = { new Student("01", "A", 19), new Student("02", "B", 20), new Student("03", "C", 21) };

		System.out.println("bubble sort: ");
		bubbleSort(digit);
		print(digit);

		System.out.println("selection sort: ");
		selectionSort(digit);
		print(digit);

		System.out.println("insertion sort: ");
		insertionSort(digit);
		print(digit);

		System.out.println("merge sort: ");
		mergeSort(digit, 0, 0);
		print(digit);

		objectSort(students);
	}

	private static void print(int[] digits) {
		for (int digit : digits) {
			System.out.print(digit + " ");
		}
		System.out.println();
	}

	public static int[] bubbleSort(int[] digit) {
		int tmp = 0;
		for (int i = 0; i < digit.length - 1; i++) {
			for (int j = 0; j < digit.length - 1 - i; j++) {
				if (digit[j] > digit[j + 1]) {
					tmp = digit[j];
					digit[j] = digit[j + 1];
					digit[j + 1] = tmp;
				}
			}
		}
		return digit;
	}

	public static int[] selectionSort(int[] digit) {
		for (int i = 0; i < digit.length; i++) {
			int min = i;
			for (int j = i + 1; j < digit.length; j++) {
				if (digit[j] < digit[min]) {
					min = j;
					int temp = digit[min];
					digit[min] = digit[i];
					digit[i] = temp;
				}
			}
		}
		return digit;
	}

	public static int[] insertionSort(int[] digit) {
		for (int i = 1; i < digit.length; i++) {
			int key = digit[i];
			int j = i - 1;
			while (j >= 0 && key < digit[j]) {
				int temp = digit[j];
				digit[j] = digit[j + 1];
				digit[j + 1] = temp;
				j--;
			}
		}
		return digit;
	}

	public static void mergeSort(int[] digit, int lowIndex, int highIndex) {
		if (lowIndex == highIndex)
			return;
		else {
			int midIndex = (lowIndex + highIndex) / 2;
			mergeSort(digit, lowIndex, midIndex);
			mergeSort(digit, midIndex + 1, highIndex);
			merge(digit, lowIndex, midIndex, highIndex);
		}
	}

	public static void merge(int[] digit, int lowIndex, int midIndex, int highIndex) {
		int[] L = new int[midIndex - lowIndex + 2];

		for (int i = lowIndex; i <= midIndex; i++) {
			L[i - lowIndex] = digit[i];
		}
		L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
		int[] R = new int[highIndex - midIndex + 1];

		for (int i = midIndex + 1; i <= highIndex; i++) {
			R[i - midIndex - 1] = digit[i];
		}
		R[highIndex - midIndex] = Integer.MAX_VALUE;
		int i = 0, j = 0;

		for (int k = lowIndex; k <= highIndex; k++) {
			if (L[i] <= R[j]) {
				digit[k] = L[i];
				i++;
			} else {
				digit[k] = R[j];
				j++;
			}
		}
	}

	public static void objectSort(Student[] students) {
		Arrays.sort(students);
		System.out.println("object sort: " + Arrays.toString(students));
	}
}
