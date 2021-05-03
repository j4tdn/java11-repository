package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		main();
	}
	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	public void publicMethod() {
		System.out.println("publicMethod");
	}
	public static void privateStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	public static void main() {
		System.out.println("Hello 02");
	}
	
	public static void sum(int a, int b) {
		System.out.println(a + b);
	}
}
class Ex02Main {
	public static void main(String[] args) {
		System.out.println("Hello03");
		// access modifier: private, public protected, default
		// private: used in internal class scope
		Ex01Main.publicStaticMethod();
		Ex01Main.privateStaticMethod();
		
		// static, non-static
		// method, attribute
		// + static: class scope (class.method())
		// + non-static: object scope (object.method())
		// object: instance of class
		// Employee: class => Emp A: object
		Ex01Main.publicStaticMethod();
		// create an object for class Ex01Main
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicMethod();
		
		
	}
}
