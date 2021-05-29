package stategy;

public class Ex01 {
	public static void main(String[] args) {
		int a = 20;
		int b = 10;
		System.out.println("Sum : " + sum(a, b));
		
		Functional f1 = (x,y) -> x + y;
		System.out.println(calculation(a, b, f1));
		
		Functional f2 = (x,y) -> x - y;
		System.out.println(calculation(a, b, f2));
		
	}
	
	private static int calculation (int a , int b , Functional f) {
		return f.func(a, b);
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
}
