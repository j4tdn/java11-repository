package exercise;
public class Ex02 {
	public static void main(String[] args) {
		long sum = factorial(4) + factorial(7)+ factorial(12) + factorial(18);
		System.out.println(sum);
	}
	private static long factorial(int a) {
		long rs = 1;
		for(int i = 1; i <= a; i++) {
			rs *= i;
		}
		return rs;
	}
}
