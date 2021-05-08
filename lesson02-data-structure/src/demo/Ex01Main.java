package demo;

public class Ex01Main {
public static void main(String[] args) {
	System.out.println("Hello 01");
}
public static void publicStaticMethod() {
	System.out.println("publicStaticMethod");	
}
public void publicMethod() {
	System.out.println("publicMethod");
}
private static void privateStaticMethod() {
	System.out.println("privateStaticMethod");
}
}
class Ex02Main {
	public static void main(String[] args) {
		System.out.println("Hello 03"); 
		
		//access modifier: private, public, protected.
		// private: used in own class scope
		Ex01Main.publicStaticMethod();
		
		//static, non-static
		//method, attribute
		//static: class scope
		//none static: object scope
		//object: instance of class
		//Employee: class => emp A: object
		//create an objec for class Ex01Main
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicMethod();
	}
}