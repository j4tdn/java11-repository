package ex04;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		if(checkPrimeEquivale(primedivisor(15), primedivisor(75))) {
			System.out.println("YES");
		}
		else System.out.println("NO");
	}

	public static boolean checkPrimeEquivale(int[] a, int[] b) {
		if (a.length != b.length) {
			return false;
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static int[] primedivisor(int num) {
		int[] result = new int[50];
		int count = 0;

		for (int i = 2; i < num; i++) {
			if (num % i == 0 && isPrimeNumber(i)) {
				result[count++] = i;
			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}

	public static boolean isPrimeNumber(int n) {
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

}
