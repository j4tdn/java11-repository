

public class Ex05 {
	public static void main(String[] args) {
		System.out.println("số nguyên tố thứ 200 là: " + findPrime(200));

	}

	private static int findPrime(int n) {
		int count = 0;
		int num = 1;
		while (count != n) {
			if (checkPrime(num)) {
				count++;
			}
			num++;
		}
		return num - 1;

	}

	private static boolean checkPrime(int n) {
		if (n == 0 || n == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}