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
		//private: used in own class scope (chi dc sd ben trong pham vi class cua no)
		Ex01Main.publicStacticMethod();
		

		//static, non-static
		//method, attribute (ham, va bien)
		//+static: class scope (neu la static thi thuoc pham vi cua class)
		//+non-static: object scope (thuoc pham vi cua doi tuong)
		//object: instance of class (la 1 instance cua class) 
		//Employee: class => Emp A: object (nhan vien A la 1 object)
		Ex01Main.privateStacticMethod();
		//create an object for class Ex01Main (tao doi tuong cho Ex01Main, tao 1 ham, 1 bien k phai la static)
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicMethod();
	}
}


	