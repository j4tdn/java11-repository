package exercise;

public class Ex06_prime {
	public static void main(String[] args) {
		primeOrder(10);

	}

	private static void primeOrder(int order) {
		int count = 0;
		int i;
		for (i = 2; i < 9999; i++) {
			if (isPrime(i)) {
				count++;
			}

			if (count == order) {
				break;
			}
		}
		System.out.println(order + "th prime number is " + i);

	}

	private static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		int squareRoot = (int) Math.sqrt(number);
		for (int i = 2; i <= squareRoot; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

}
