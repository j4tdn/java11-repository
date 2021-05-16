package control;

public class Ex01 {
	
	public static void main(String[] args) {
		int a = 8;
		int b =6;
		int c = 10;
		
		System.out.println("max 1: "+ max(a, b));
		System.out.println("max 1: "+ max(a, b, c));
		
	}
	
	private static int max(int a, int b) {
		if (a>b) {
			return a;
		}
		return b;
	}
	private static int max(int a, int b, int c) {
		int max = a > b ? a : b;
		if (max < c) max = c;
		return max;
	}
}
