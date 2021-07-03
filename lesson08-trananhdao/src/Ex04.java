
public class Ex04 {
	public static void main(String[] args) {
	       
		if (result(75)==result(15)) {
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

	private static int result(int n) {
		int s =0;
		for (int i = 2; i <= n; i++) {
			if (n % i == 0 && checkPrime(i)) {
				s = s + i;
			}
		}
		return s;
	}
}
