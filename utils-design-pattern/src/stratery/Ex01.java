package stratery;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		
		System.out.println("sum: " + sum(a, b));
		System.out.println("sub: " + sub(a, b));
		
		Functional f = (x, y) -> x + y;
		System.out.println(calculatate(a, b, f));
	}
	
	// stratery pattenrn
	private static int calculatate(int a, int b, Functional f) {
		return f.func(a, b);
	}
	
	private static int sum(int a, int b) {
		return a + b;
	}
	
	private static int sub(int a, int b) {
		return a - b;
	}
}
