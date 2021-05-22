package bai03;

public class IsPowerOf {
	public static void main(String[] args) {
		int a = 2;
		int b = 4;
		System.out.println("isPowerOf: " + isPowerOf(a, b));
	}
	
	private static boolean isPowerOf(int a, int b) {
		if (a == 1)
			return (b == 1);
		int pow = 1;
		while (pow < b)
			pow = pow * a;
		return (pow == b);
	}
}
