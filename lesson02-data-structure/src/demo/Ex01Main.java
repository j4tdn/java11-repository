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
	   System.out.println("privateStaticMethod");
   }
   
   public static void main() {
	   System.out.println("Hello 02");
  }
}

class Ex02Main {
	public static void main(String[] args) {
		System.out.println("Hello 03");
		
		// access modifier: private, public, protected, 
		// private: used in own class scope
		Ex01Main.publicStaticMethod();
		// Ex01Main.privateStaticMethod();
		
		// static, non-static
		// method, attribute
		// + static: class scope
		// + non-static: object scope
		// object: instance of class
		// Employee: class => Emp A: object
		Ex01Main.publicStaticMethod();
		// create an object for class Ex01Main
		Ex01Main ex01object = new Ex01Main();
		ex01object.publicMethod();
	}
}

  
