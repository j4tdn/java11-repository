package bt;

public class Bt04 {
	public static void main(String[] args) {
		if (getDivisorPrime(15).equals(getDivisorPrime(75))) {
			System.out.println("YES");
		} else
			System.out.println("NO");
	}

	private static boolean checkPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private static String getDivisorPrime(int n) {
		String str = null;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && checkPrime(i)) {
				str = str + i;
			}
		}
		return str;
	}
}
