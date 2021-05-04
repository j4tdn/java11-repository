package homework;

public class Ex02 {
	public static void main(String[] args) {
		long result;
		result = TGT(4) +TGT(7) + TGT(12) +TGT(18);
		System.out.println("tong cua luy thua la: " +result);
	}
	
	private static long TGT(int n) {
		long result = 1;
		if (n == 0 || n ==1 )
			return 1;
		for (int i=1; i<=n; i++) {
			result=result*i;
		} return result;
	}
	
	
}
