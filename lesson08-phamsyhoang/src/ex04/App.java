package ex04;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		int n = 12, m = 18;
		check(n, m);
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		int squareRoot = (int) Math.sqrt(n);
		for (int i = 2; i <= squareRoot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static int[] Divisor(int n) {
		int[] arr = new int[n];
		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0 && isPrime(i) == true) {
				arr[count++] = i;
			}
		}
		return Arrays.copyOfRange(arr, 0, count);
	}

	private static void check(int n, int m) {
		String s1 = Arrays.toString(Divisor(n));
		String s2 = Arrays.toString(Divisor(m));

		if (s1.contains(s2)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
