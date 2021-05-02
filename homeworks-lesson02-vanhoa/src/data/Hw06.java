package data;

public class Hw06 {
	public static void main(String[] args) {
		int count = 0;
		long n = 0;
		while (count < 200) {
			n++;
			if (isPrime(n)) {
				count++;
			}
		}
		System.out.println("200th prime number is: " + n);
		// System.out.println("Test method isPrime: " + isPrime(7));

	}

	private static boolean isPrime(long n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;

	}

}
