package demo;

public class Ex02 {
	public static void main(String[] args) {
		int a = 10;
		int b = 0;
		
		System.out.println("Result : " + divide(a, b));
	}
	
	private static int divide(int a, int b) {
		// ArithmeticException
		return a / b;
	}
}
