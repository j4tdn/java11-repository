package exercise01;

import java.util.Arrays;

import utils.ArrayUtils;

public class Ex01 {
	public static void main(String[] args) {
		int[] numbers = { 3, 6, 8, 5, 8, 6, 8, 1 };
		int[] digits = { 7, 8, 8, 8, 6, 2, 5, 1 };

		int[] duplicate = removeDuplicates(numbers);
		System.out.print("remove duplivate: ");
		ArrayUtils.printf(duplicate);
		System.out.println();

		compareAverage(numbers);

		System.out.println();
		System.out.println("third largest: " + findLargest(numbers, 4));
		System.out.println("test 3rd: " + findLargest(digits, 3));
	}

	private static int[] removeDuplicates(int[] numbers) {
		int[] result = new int[numbers.length];
		int index = 0;
		for (int i = 0; i < numbers.length; i++) {

			boolean dup = false;

			for (int j = 0; j < numbers.length; j++) {
				if (i == j) {
					continue;
				}
				if (numbers[i] == numbers[j]) {
					dup = true;
					break;
				}
			}
			if (!dup) {
				result[index++] = numbers[i];
			}
		}

		return Arrays.copyOfRange(result, 0, index);
	}

	private static void compareAverage(int[] numbers) {
		int n = numbers.length / 2;
		int sumA = 0;
		int sumB = 0;
		for (int i = 0; i < n; i++) {
			sumA += numbers[i];
			sumB += numbers[numbers.length - 1 - i];
		}
		if (sumA < sumB) {
			System.out.println("average elements before n/2 is less than average elements after n/2");
		} else if (sumA > sumB) {
			System.out.println("average elements before n/2 is more than average elements after n/2");
		} else {
			System.out.println("they are equal");
		}

	}

	private static int findLargest(int[] numbers, int index) {
		int[] tmpArr = Arrays.copyOfRange(numbers, 0, numbers.length);
		int tmp = 0;
		int c = 1;
		int result = 0;

		// sort by descending order
		for (int i = 0; i < tmpArr.length; i++) {
			for (int j = i + 1; j < tmpArr.length; j++) {
				if (tmpArr[i] < tmpArr[j]) {
					tmp = tmpArr[i];
					tmpArr[i] = tmpArr[j];
					tmpArr[j] = tmp;
				}
			}
		}
//		ArrayUtils.printf(tmpArr);

		for (int i = 0; i < tmpArr.length - 1; i++) {
			if (tmpArr[i] > tmpArr[i + 1]) {
				c++;
			}
			if (c == index) {
				result = tmpArr[i + 1];
			}
		}

		return result;
	}

}
