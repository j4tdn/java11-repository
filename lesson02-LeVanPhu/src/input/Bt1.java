package input;

public class Bt1 {
	public static void main(String[] args) {
		
		int a = 1024;
		isPow(a);
	}

	private static void isPow(int n) {
		int a = n;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				System.out.println( a + " is not Pow of 2");
				return ;
				
			}
		}
		System.out.println(a + " is Pow of 2");
	}
}
