package bai03;

public class LuyThua {
	public static void main(String[] args) {
       System.out.println(isPowerOf(8, 2));
       System.out.println(isPowerOf(6, 2));
       System.out.println(isPowerOf(20, 4));
       System.out.println(isPowerOf(64, 4));
	}

	public static boolean isPowerOf(int a, int b) {
		for (int i = 0; i <= a; i++) {
			if (Math.pow(b, i) == a) {
				return true;
			}
		}
		return false;
	}
}
