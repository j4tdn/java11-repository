package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		// main();
	}

	public static void publicStacticMethod() {
		System.out.println("publicStaticMethod");
	}
	
	public void publicMethod() {
		System.out.println("publicMethod");
	}
	
	public static void privateStacticMethod() {
		System.out.println("privateStaticMethod");
	}
}

class Ex02main {
	public static void main(String[] args) {
		System.out.println("hello 03");
		//access modifier: private, public, protected 
		//private: used in own class scope
		Ex01Main.publicStacticMethod();

		//static, non-static
		//method, attribute 
		//+static: class scope 
		//+non-static: object scope
		//object: instance of class 
		//Employee: class => Emp A: object
		Ex01Main.privateStacticMethod();
		//create an object for class Ex01Main
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicMethod();
	}
}


	