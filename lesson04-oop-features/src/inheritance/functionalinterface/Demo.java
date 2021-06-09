package inheritance.functionalinterface;

public class Demo {
	private static int a = 10;
	private static int b = 10;

	public static void main(String[] args) {
		System.out.println("sum: " + calculate(10, 20, (a, b) -> a - b));
	}
	
	private static int calculate(int a, int b, Manipulation mal) {
		return mal.perform(a, b);
	}
	
	private static int sum() {
		return a + b;
	}
	
	private static int sub() {
		return a + b;
	}
	
	private static int devide() {
		return a + b;
	}
	
	private static int multiple() {
		return a + b;
	}
}
