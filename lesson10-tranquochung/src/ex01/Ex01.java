package ex01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {

		int[] numbers = { 3, 3, 4 };

		// Remove duplicate elements
		int[] removeAfter = removeDuplicate(numbers);
		for (int i = 0; i < removeAfter.length; i++) {
			System.out.print(removeAfter[i] + " ");
		}
		System.out.println("\n=================");

		// Compare the mean of the first n/2 elements with the last n/2 elements
		compareAvgFirstLast(numbers);
		System.out.println("\n=================");

		// Find the 3rd largest number in the array
		int max3rd = findNumber3rd(numbers);
		System.out.println("3rd largest number is :  " + max3rd);
	}

	private static int[] removeDuplicate(int[] numbers) {
		int[] results = new int[numbers.length];
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (checkExist(numbers, numbers[i])) {
				results[count++] = numbers[i];
			}
		}
		return Arrays.copyOfRange(results, 0, count);
	}

	private static boolean checkExist(int[] digits, int number) {
		int count = 0;
		for (int i = 0; i < digits.length; i++) {
			if (digits[i] == number)
				count++;
		}
		if (count > 1)
			return false;
		return true;
	}

	private static void compareAvgFirstLast(int[] numbers) {
		int avgfirst = 0;
		int avglast = 0;
		if (numbers.length == 0) {
			avgfirst = numbers[1];
			avglast = numbers[2];
		} else {
			for (int i = 0; i < numbers.length / 2; i++) {
				avgfirst += numbers[i];
				avglast += numbers[numbers.length - i - 1];
			}
		}
		if (avgfirst == avglast) {
			System.out.println("AVG Frist = AVG Last");
		} else {
			if (avgfirst > avglast) {
				System.out.println("AVG Frist > AVG Last");
			} else {
				System.out.println("AVG Frist < AVG Last");
			}
		}
	}

	private static int findNumber3rd(int[] numbers) {
		int max = numbers[0];
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max)
				max = numbers[i];
		}
		int max2 = max(numbers, max);
		return max(numbers, max2);
	}

	private static int max(int[] numbers, int number) {
		int max = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < number) {
				max = numbers[i];
				break;
			}
		}
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] > max && numbers[i] < number)
				max = numbers[i];
		}
		return max;
	}
}
