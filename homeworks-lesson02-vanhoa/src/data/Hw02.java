package data;

public class Hw02 {
	public static void main(String[] args) {
		int a = 4;
		int b = 7;
		int c = 12;
		int d = 18;
		System.out.println("test 5! = " + factorial(5));
		long S = 0;
		S = factorial(a) + factorial(b) + factorial(b) + factorial(c) + factorial(d);
		System.out.println("S = 4! + 7! + 12! + 18! = " + S);
		//long f = fa(4);
		// System.out.println("=====");
		// System.out.println(f);
	}

	private static long factorial(int n) {
		long t = 1;
		for (int i = 1; i <= n; i++) {
			t *= i;
		}
		return t;
	}

//	private static long fa(int n) {
//		if (n < 0)
//			return 0;
//		if (n == 0 || n == 1)
//			return 1;
//		return n * fa(n - 1);
//	}

}
