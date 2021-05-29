package functional;

public class Ex01 {
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		/*
		 * input: a, b
		 * condition ?
		 * result a ? b
		 */
		Functional f = (x , y) -> x -y;
		System.out.println("resault: " + calculate(a, b, f));
	}
	
	// strategy pattern
	private static int calculate(int a, int b, Functional f) {
		return f.func(a, b);
	}
	
}
