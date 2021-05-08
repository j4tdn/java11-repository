package homework1;

public class BT2 {
	public static void main(String[] args) {
		long result;
		result = giaiThua1(4)+giaiThua1(7)+giaiThua1(12)+giaiThua1(18);
		System.out.println("Ket qua la : "+result);
	}
	
//	private static long giaiThua1(long n) {
//		long result = 1;
//		for(long i = 1; i<= n; i++) {
//			result = result*i;
//		}
//		return result;
//	}
	private static long giaiThua1(long n) {
		if(n==0||n==1) return 1;
		return n*giaiThua1(n-1);
	}
	
}
