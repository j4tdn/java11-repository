package exercises;

public class Ex02 {
	public static void main(String[] args) {
		long s = GT(4) + GT(7) + GT(12) + GT(18);
		System.out.println("sumGT :" + s);
	}
	
	private static long GT(int n) {
		long s = 1;
		for(int i = 1; i <= n; i++) {
			s = s * i;
		}
		return s;
	}
}
