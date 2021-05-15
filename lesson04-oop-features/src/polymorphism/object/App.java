package polymorphism.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing();

		Rectangle rectangle = new Rectangle();
		rectangle.drawing();
		rectangle.setBackground();

		Square square = new Square();
		square.drawing();

		System.out.println("===============");
		Shape s1 = new Rectangle();
		s1.drawing();
		System.out.println("RT: " + s1.getClass().getName());

		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RT: " + s2.getClass().getName());

		s1 = s2;
		s2 = s1;

		// Rectangle r1 = new Shape();
		// r1.setBackground();

		// conclusion: goad of polymorphism with object
		// 1. easy modify data type of object
		// 2. hide the way create object >> factory-pattern

		// factory-pattern: initial
		// hide object creation

		// collectionsL fixed-size, list
		// list(student)
		// max: 10students int[] students = new int[10];
		// 		30students 		 students = new int[30];
		// 		100students		 students = new int[100];
		
		//rectangle = sqare; no - relationship
		//sqare = rectangle;

		// compile time: CT
		// run time: RT
		// s1: CT: shape, RT: Rectangle;
		// s2: CT: shape, RT: Square;
		

	}
}
