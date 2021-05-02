package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		main();
	}
	
	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	
	private static void privateStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	
	public static void main() {
		System.out.println("Hello 02");
	}
	public void publicMethod() {
		System.out.println("publicMethod");
	}
	


public static int sum(int a, int b) {
	return a+b;
}

class Ex02Main {
	public void main(String[] args) {
		System.out.println("Hello 03");
		Ex01Main.publicStaticMethod();
		
		//static, non static
		Ex01Main ex01Object =new Ex01Main();
		ex01Object.publicMethod();
		
	}
}
}
