package data;

public class Hw05 {
	public static void main(String[] args) {
		int n = 116;
		System.out.println("Base 2 of " + n + " is: " + convertBinary(n));
	}

	private static long convertBinary(int n) {
		long c = 0;
		long s;
		long i = 1;

		while (n > 0) {
			s = n % 2;
			c += i * s;
			n /= 2;
			i *= 10;
		}
		return c;
	}

}
