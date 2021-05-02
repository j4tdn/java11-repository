
public class Ex02 {
	public static void main(String[] args) {
		System.out.println(getFactorial(4) + getFactorial(7) + getFactorial(12) + getFactorial(18));
	}

	private static long getFactorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * getFactorial(n - 1);
	}
}
