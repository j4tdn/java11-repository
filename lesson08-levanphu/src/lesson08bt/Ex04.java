package lesson08bt;
import java.util.Arrays;
public class Ex04 {
	public static void main(String[] args) {
		int M = 15;
		int N = 25;
		if(check(M,N) == false) {
			System.out.println("NO");
		}else
			System.out.println("YES");
	}

	private static void printf(int input) {
		int[] resultM = getPrime(input);
		for (int i = 0; i < resultM.length; i++) {
			System.out.print(resultM[i] + " ");
		}

		System.out.println();
	}

	private static boolean check(int M, int N) {
		int[] resultM = getPrime(M);
		int[] resultN = getPrime(N);
		if (resultM.length != resultN.length) {
			return false;
		}

		for (int i = 0; i < resultM.length; i++) {
			if (resultM[i] != resultN[i]) {
				return false;
			}
		}

		return true;
	}

	private static int[] getPrime(int n) {
		int[] result = new int[n];
		int index = 0;
		for (int i = 2; i < n; i++) {
			if (n % i == 0 && isPrime(i)) {
				result[index++] = i;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
