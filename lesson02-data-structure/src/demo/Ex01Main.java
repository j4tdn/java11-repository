package demo;

public class Ex01Main {
	public static void main(String[] args) {
		System.out.println("Hello 01");
		main();
	} 
	public static void publicStaticMethod() {
		System.out.println("publicStaticMethod");
	}
	
		public void publicmethod(){
			
		}
	
	private static void privateStacticMethod() {
		System.out.println("privateStaticMethod");
	}
	
	public static void main() {
		System.out.println("Hello 02");
	}
}

class Ex02Main {
	public static void main(String[]args) {
		System.out.println("Hello 03");
		Ex01Main.publicStaticMethod();
		//Ex01Main.privateStacticMethod();
		//access modifier:public, public, protected
		//
		//static, non-static
		//method, attribute
		//+ static:class scope
		//+ non-static: object scope
		//object: instance of class
		//Employe:class+> Emp A: object
		
		//create an object for class Ex01Main
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicmethod();
	}
}
