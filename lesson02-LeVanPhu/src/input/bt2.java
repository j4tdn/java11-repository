package input;

public class bt2 {
	public static void main(String[] args) {
		long a = GiaiThua(4) + GiaiThua(7) + GiaiThua(12) + GiaiThua(18);
		System.out.println(a);
	}
	private static  long GiaiThua(int n) {
		long S = 1;
		for(int i=1;i<=n;i++) {
		S = S * i;
		}
		return S;
	}

}
