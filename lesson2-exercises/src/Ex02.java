
public class Ex02 {
	public static void main(String[] args) {
		long s = luythua(4) + luythua(7) + luythua(12) + luythua(18);
		System.out.println(s);
	}
	
	public static long luythua(int n) {
		if (n==1 || n==0) return 1;
		return n*luythua(n-1);
	}
}
