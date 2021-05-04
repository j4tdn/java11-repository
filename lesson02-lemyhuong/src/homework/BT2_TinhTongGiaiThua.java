package homework;

public class BT2_TinhTongGiaiThua {
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		int c = 12;
		int d = 18;
		Long S = 1L;

//		System.out.println(factorial(a));

		S = factorial(a) + factorial(b) + factorial(c) + factorial(d);
		System.out.println("S = " + a + "! + " + b + "! + " + c + "! + " + d + "! " + "= " + S);
	}

	private static long factorial(int a) {
		int i = 1;
		long factorial = 1L;
		while (i <= a) {
			factorial *= i;
			i++;
		}
		return factorial;
	}
}
