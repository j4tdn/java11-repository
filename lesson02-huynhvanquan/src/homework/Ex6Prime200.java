package homework;

public class Ex6Prime200 {
	public static void main(String[] args) {
		int prime = 1;
		int count = 0;
		while (count != 200) {
			if (isPrime(++prime)) {
				++count;
			}
		}
		System.out.println("The prime is at position 200: " + prime);
	}
	static boolean isPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
