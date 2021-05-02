package data;

public class Ex05 {
	public static void main(String[] args) {
		Integer a = 10;
		Integer b = 20;
		swap(a,b);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
	}
	private static void swap(Integer a ,Integer b) {
		int tmp = a;
		a = b;
		b = tmp;
	}
}
