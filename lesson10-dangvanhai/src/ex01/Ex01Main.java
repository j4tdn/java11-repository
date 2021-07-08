package ex01;

import java.util.Arrays;
import java.util.Random;

public class Ex01Main {
	public static void main(String[] args) {
		// Create a integer random array with a range[10-20] for length
		Random random = new Random();
		int len = random.nextInt(20 - 10) + 10;
		int[] arr = new int[len];
		for (int i = 0; i < len; i++) {
			arr[i] = random.nextInt(20);
		}
		System.out.println("Origin Array: \n" + Arrays.toString(arr));

		// Remove duplicate elements
		System.out.println("Array Before Removed Duplicate: \n" + Arrays.toString(removeDuplicates(arr)));

		// Compare average of first half and second half
		System.out.println("Compare Average Half: " + compareAverageHalf(arr));

		// Find third largest element in an array
		System.out.println("Third Largest Element: " + findLargest(arr, 3));

	}

	private static int findLargest(int[] arr, int ordinal) {
		int[] tempArr = Arrays.copyOf(arr, arr.length);
		Arrays.sort(tempArr);
		int count = 1;
		for (int i = 1; i < tempArr.length; i++) {
			if (tempArr[i] > tempArr[i - 1]) {
				count++;
				if (count == ordinal) {
					return tempArr[i];
				}
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param arr
	 * @return the value {0} if {average of first half == average of second half};
	 *         the value {1} if {average of first half > average of second half};
	 *         the value {-1} if {average of first half < average of second half}
	 */
	private static int compareAverageHalf(int[] arr) {
		if (arr.length <= 1) {
			return 0;
		}
		int value = 0;
		for (int i = 0; i < arr.length / 2; i++) {
			value = value + arr[i] - arr[arr.length - i - 1];
		}
		return (value < 0) ? -1 : (value == 0) ? 0 : 1;
	}

	private static int[] removeDuplicates(int[] arr) {
		// Counter the number duplicate of elements
		int[] counter = new int[max(arr) + 1];
		for (int i = 0; i < arr.length; i++) {
			counter[arr[i]]++;
		}

		// Save elements is not duplicate
		int[] result = new int[arr.length];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (counter[arr[i]] == 1) {
				result[index++] = arr[i];
			}
		}

		return Arrays.copyOfRange(result, 0, index);
	}

	private static int max(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException("Require length of array great than 0");
		}
		int max = arr[0];
		for (int i : arr) {
			max = (i > max) ? i : max;
		}
		return max;
	}

}
