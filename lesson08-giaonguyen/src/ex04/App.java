package ex04;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {

		int[] result1 = findPrimeDivisor(75);
		int[] result2 = findPrimeDivisor(15);
		
		for (int i = 0; i < result1.length; ++i) {
			System.out.println(result1[i]);
		}

		for (int i = 0; i < result2.length; ++i) {
			System.out.println(result2[i]);
		}

		int count = 0;

		if (result1.length != result2.length) {
			System.out.println("Invalid equivalent prime number!");
		}
		else {
			for (int i = 0; i < result1.length; ++i) {
				if (result1[i] == result2[i]) {
					count++;
				}
			}

			if (count == result1.length) {
				System.out.println("Valid equivalent prime number!");
			}
		}
	}

	public static int[] findPrimeDivisor(int num) {
		int[] result = new int[50];
		int count = 0;

		for (int i = 2; i < (num/2); ++i) {
			if (num % i == 0) {
				if (isPrimeNum(i)) {
					result[count++] = i;
				}
			}
		}

		return Arrays.copyOfRange(result, 0, count);
	}


	public static boolean isPrimeNum (int num) {
		for (int i = 2; i < (num/2); ++i) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
