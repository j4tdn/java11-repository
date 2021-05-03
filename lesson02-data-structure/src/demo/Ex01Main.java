package demo;

public class Ex01Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		System.out.println("Hello 01");
=======
		System.out.println("hello 1");
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
		main();
	}
	
	public static void publicStaticMethod() {
<<<<<<< HEAD
		System.out.println("publicStaticMedthod");
=======
		System.out.println("publicStaticMethod");
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
	}
	
	public void publicMethod() {
		System.out.println("publicMethod");
	}
	
	private static void privateStaticMethod() {
<<<<<<< HEAD
		System.out.println("privateStaticMedthod");
	}
	
	public static void main() {
		System.out.println("Hello 02");
=======
		System.out.println("publicStaticMethod");
	}
	public static void main() {
		System.out.println("hello 2");
	
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
	}
}

class Ex02Main {
	public static void main(String[] args) {
<<<<<<< HEAD
		System.out.println("Hello 03");
		// access modifier: private, public,protected
		Ex01Main.publicStaticMethod();
		//Ex01Main.privateStaticMethod();
		
		//static & non static
=======
		System.out.println("hello 3");
		//access modifier: private, public, protected
		//private: used in own class scope
		Ex01Main.publicStaticMethod();
		
		//stactic, non-static
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
		//method, attribute
		// +static: class scope
		// +non-static: object scope
		//object: instance of class
<<<<<<< HEAD
		Ex01Main.publicStaticMethod();
		//create an object for class Ex01Main
		Ex01Main ex01Object = new Ex01Main();
		ex01Object.publicMethod();
=======
		//employee: class => emp A: object
		//creat an an object for class EX01Main
		Ex01Main.publicStaticMethod();
		Ex01Main ex01object = new Ex01Main();
		ex01object.publicMethod();
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
	}
}