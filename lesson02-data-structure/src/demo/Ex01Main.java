package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		main(new int[20]);
	}
	
	public static void main(int[] vars) {
		System.out.println("Hello 02");
	}
	
	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	private static void privateStaticMethod() {
		System.out.println("privateStaticMethod");
	}
	public  void publicMethod() {
		System.out.println("publicMethod");
	}
}

class Ex02Main{
	public static void main(String[] args) {
		System.out.println("Hello 03");
		Ex01Main.publicStaticMethod();
	}
}
