package Java11;

public class Bt2 {
	public static void main(String[] args) {
		System.out.println(giaiThua(4)+giaiThua(7)+giaiThua(12)+giaiThua(18));
	}

	public static long giaiThua(int n) {
		long tmp = 1;
		if(n>1) {
			for (int i = 2; i <= n; i++) {
				tmp *=i; 
			}
		}
		return tmp;
	}
}
