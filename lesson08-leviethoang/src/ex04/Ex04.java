package ex04;

import java.util.Arrays;

public class Ex04 {
	public static void main(String[] args) {
		int m = 18; // 2 3
		int n = 12;

		if (check(m, n)) {
			System.out.print(m + " và " + n + " là nguyên tố tương đương có chung các ước nguyên tố : ");
			printf(m);
		} else {
			System.out.println(m + " và " + n + " Không phải là nguyên tố tương đương");
		}
	}

	private static void printf(int input) {
		int[] resultM = getAllPrime(input);
		for (int i = 0; i < resultM.length; i++) {
			System.out.print(resultM[i] + " ");
		}

		System.out.println();
	}

	private static boolean check(int m, int n) {
		int[] resultM = getAllPrime(m);
		int[] resultN = getAllPrime(n);
		if (resultM.length != resultN.length) {
			return false;
		}

		for (int i = 0; i < resultM.length; i++) {
			if (resultM[i] != resultN[i]) {
				return false;
			}
		}

		return true;
	}

	private static int[] getAllPrime(int n) {
		int[] result = new int[n];
		int index = 0;
		for (int i = 2; i < n; i++) {
			if (n % i == 0 && isPrime(i)) {
				result[index++] = i;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

}
