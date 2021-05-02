
public class Ex06 {
	public static void main(String[] args) {
		int result = 2;
		for (int i = 2; i <= 200; i++) {
			result = nextPrime(result);
			System.out.println(i + ": " + result);
		}
		System.out.println("result: " + result);
	}

	private static boolean isPrime(int n) {
		// Corner cases
		if (n <= 1)
			return false;
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;

		for (int i = 5; i * i <= n; i = i + 6)
			if (n % i == 0 || n % (i + 2) == 0) {
				return false;
			}

		return true;
	}

	private static int nextPrime(int n) {
		while (true) {
			if (isPrime(++n))
				return n;
		}
	}
}
