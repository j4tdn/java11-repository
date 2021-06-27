package ex04;

public class App {
	public static void main(String[] args) {
		int a = 15, b = 75;
		System.out.println(findDivisorPrime(a).equals(findDivisorPrime(b)) ? "YES" : "NO");
	}
	
	private static boolean checkPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	private static String findDivisorPrime(int num) {
		String text = "";
		for(int i = 2; i <= num; i++) {
			if (num % i == 0 && checkPrime(i)) {
				text += i;
			}
		}
		return text;
	}
}
