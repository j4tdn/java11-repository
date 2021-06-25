package ex;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		System.out.println(isEquivalentPrimeNumber(15, 75));
		System.out.println(isEquivalentPrimeNumber(12, 60));
		System.out.println(isEquivalentPrimeNumber(15, 45));
	}

	private static boolean isEquivalentPrimeNumber(int a, int b) {
		return compare(factorialPrime(a), factorialPrime(b));
	}

	private static int[] factorialPrime(int number) {
		int[] result = new int[number];
		int count = 0;
		for (int i = 2; i <= number; i++) {
			if (number % i == 0) {
				result[count++] = i;
			}
			while (number % i == 0) {
				number /= i;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	private static boolean compare(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
}
