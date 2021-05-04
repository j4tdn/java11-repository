package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		main();
	}
	
	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}

	private static void main() {
		System.out.println("Hello 02");
	}

	
class Ex02Main {
	public void main(String[] args) {
		System.out.println("Hello 03");
		
		// access modifier:private public, protected.
		// private: used in own class scope.
		Ex01Main.publicStaticMethod();
		// static, non-static.
		// attribute
		// +static:class scope
		// +non-static: object scope
		// object: instance of class 
		// Employee: class=>Emp A:object
		Ex01Main.publicStaticMethod();
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicStaticMethod();
	}
}
}
