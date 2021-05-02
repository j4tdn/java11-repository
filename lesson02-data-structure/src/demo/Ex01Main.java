package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01 ");
		main();
	}

	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}

	private static void privateStaticMethod() {
		System.out.println("publicStaticMethod");
	}

	public void publicMetod() {
		System.out.println("publicMethod");
	}

	public static void main() {
		System.out.println("Hello 02");
	}
}

class Ex02Main {
	public static void main(String[] args) {
		System.out.println("Hello 03");

		// access modifier: private,public,protected,default
		Ex01Main.publicStaticMethod();

		// static,non-static
		// method,attribute
		// + static: class scope
		// + non-static:object scope
		// object: instance of class
		// Employee: class => Emp A: object
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicMetod();
	}
}
