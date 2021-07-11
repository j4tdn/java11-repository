package ex01;

import static utils.ArrayUtils.printf;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 3, 1 };
		System.out.print("Mảng a[] = ");
		printf(a);

		removeDuplicate(a);
		compareAverage(a);

		int[] b = { 7, 8, 8, 8, 6, 2, 5, 1 };
		System.out.print("\nMảng b[] = ");
		printf(b);
		max(diffElement(b));

	}

//
	private static void removeDuplicate(int[] digits) {
		Arrays.sort(digits);
		for (int i = 0; i < digits.length - 1; i++) {
			for (int j = i + 1; j < digits.length; j++) {
				if (digits[i] == digits[j]) {
					digits = removeElement(digits, j);
					digits = removeElement(digits, i);
				}
			}
		}
		System.out.print("1. Mảng sau khi loại bỏ phần tử trùng nhau: a[] = ");
		printf(digits);
	}

	private static void compareAverage(int[] digits) {
		double preSum = 0, folSum = 0;
		int average = digits.length / 2;

		for (int i = 0; i < digits.length; i++) {
			if (i < average) {
				preSum += digits[i];
			} else {
				folSum += digits[i];
			}
		}
		preSum = preSum / average;
		folSum = folSum / average;

		if (preSum < folSum) {
			System.out.println("2. Gía trị trung bình của n/2 phần tử đầu tiên bé hơn n/2 phần tử cuối cùng");
		} else if (preSum > folSum) {
			System.out.println("2. Gía trị trung bình của n/2 phần tử đầu tiên lớn hơn n/2 phần tử cuối cùng");
		} else {
			System.out.println("2. Gía trị trung bình của n/2 phần tử đầu tiên bằng n/2 phần tử cuối cùng");
		}
	}

	private static int[] removeElement(int[] digits, int pos) {
		int[] result = new int[digits.length - 1];
		for (int i = 0; i < digits.length; i++) {
			if (i < pos) {
				result[i] = digits[i];
			} else if (i > pos) {
				result[i - 1] = digits[i];
			}
		}
		return result;
	}

	private static int[] diffElement(int[] digits) {
		int result[] = new int[digits.length];
		int count = 0;
		boolean same;
		for (int i = 0; i < digits.length; i++) {
			same = false;
			for (int j = 0; j < count; j++) {
				if (digits[i] == result[j]) {
					same = true;
					break;
				}
			}
			if (!same) {
				result[count++] = digits[i];
			}
		}

		return Arrays.copyOfRange(result, 0, count);
	}

	private static void max(int[] digits) {
		int count = 1;
		int max;
		do {
			max = digits[0];
			int pos = 0;
			for (int i = 1; i < digits.length; i++) {
				if (max < digits[i]) {
					max = digits[i];
					pos = i;
				}
			}
			digits = removeElement(digits, pos);
			count++;
		} while (count <= 3);
		System.out.println("3. Số lớn thứ 3 trong mảng b = " + max);

	}

}
