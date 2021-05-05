package data;

public class Hw01CheckPowerOf2 {
	public static void main(String[] args) {
		int n = 8;
		boolean p = isPowerOf2(n);
		if (p) {
			System.out.println(n + " is power of 2");
		}
		else {
			System.out.println(n + " is not power of 2");
		}

	}
	private static boolean isPowerOf2 (int n) {
		if(n==0) {
			return false;
		}
		while(n%2==0) {
			n = n/2;
		}
		return n==1;
	}

}
