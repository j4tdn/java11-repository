package strategy;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		Functional f = (x, y) -> x + y;
		System.out.println(calculate(a, b, f));
	}
	
	public static int calculate(int a, int b, Functional f) {
		return f.func(a, b);
	}
	

}
