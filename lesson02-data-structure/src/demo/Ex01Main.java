package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("hello 1");
		main();
	}
	
	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	
	public void publicMethod() {
		System.out.println("publicMethod");
	}
	
	private static void privateStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	public static void main() {
		System.out.println("hello 2");
	
	}
}

class Ex02Main {
	public static void main(String[] args) {
		System.out.println("hello 3");
		//access modifier: private, public, protected
		//private: used in own class scope
		Ex01Main.publicStaticMethod();
		
		//stactic, non-static
		//method, attribute
		// +static: class scope
		// +non-static: object scope
		//object: instance of class
		//employee: class => emp A: object
		//creat an an object for class EX01Main
		Ex01Main.publicStaticMethod();
		Ex01Main ex01object = new Ex01Main();
		ex01object.publicMethod();
	}
}