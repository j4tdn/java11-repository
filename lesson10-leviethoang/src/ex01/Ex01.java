package ex01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4, 3, 1 }; // {2, 4}
		print(uniqueNumbers(digits));
		compareAverage(digits);
		int[] newDigits = { 7, 8, 8, 8, 6, 2, 5, 1 }; // 6
		System.out.println("Third largest number in arrays : " + ThirdLargestNub(newDigits));

	}

	private static void print(int[] digits) {
		for (int digit : digits) {
			System.out.print(digit + " ");
		}
		System.out.println();
	}

	private static int[] uniqueNumbers(int[] digits) {
		int[] newDigits = Arrays.copyOfRange(digits, 0, digits.length);
		int index = 0;
		boolean[] flags = new boolean[digits.length];

		for (int i = 0; i < digits.length; i++) {
			for (int j = 0; j < digits.length; j++) {
				if (i != j && newDigits[i] == newDigits[j]) {
					flags[i] = true;
					flags[j] = true;
				}
			}
		}

		for (int i = 0; i < newDigits.length; i++) {
			if (!flags[i]) {
				newDigits[index++] = digits[i];
			}
		}

		return Arrays.copyOfRange(newDigits, 0, index);
	}

	private static double avarage(int[] digits) {
		double result = 0;
		for (int i = 0; i < digits.length; i++) {
			result += digits[i];
		}
		return result / digits.length;
	}

	private static int[] reverse(int[] digits) {
		int[] newDigits = new int[digits.length];
		int index = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			newDigits[index++] = digits[i];
		}
		return newDigits;
	}

	private static void compareAverage(int[] digits) {
		int[] firstArr = Arrays.copyOfRange(digits, 0, digits.length / 2);
		int[] tmp = reverse(digits);
		int[] endArr = Arrays.copyOfRange(tmp, 0, digits.length / 2);

		double avarageF = avarage(firstArr);
		double avarageE = avarage(endArr);
		if (avarageF == avarageE) {
			System.out.println("EQUAL");
		} else if (avarageF > avarageE) {
			System.out.println("BIGGER");
		} else {
			System.out.println("SMALLER");
		}
	}

	private static int ThirdLargestNub(int[] digits) {
		int thirdMN = 0;
		Arrays.sort(digits); // 1 2 5 6 7 8 8 8
		int count = 0;
		for (int i = digits.length - 1; i > 0; i--) {
			if (digits[i] > digits[i - 1]) {
				count++;
				if (count == 3) {
					thirdMN = digits[i];
				}
			}
		}

		return thirdMN;
	}

}
