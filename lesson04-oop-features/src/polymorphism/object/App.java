package polymorphism.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing(); // Shape >> drawing
		
		Rectangle rectangle = new Rectangle();
		rectangle.drawing(); // Rectangle >> drawing
		rectangle.setBackground(); // Rectangle >> setting background
		
		Square square = new Square();
		shape.drawing(); // Square >> drawing
		
		System.out.println("==================");
		Shape s1 = new Rectangle();
		s1.drawing(); // Rectangle >> drawing
		System.out.println("RT: " + s1.getClass().getName());
		
		Shape s2 = new Square();
		s2.drawing(); // Square >> drawing
		System.out.println("RT: " + s2.getClass().getName());
		
		s1 = s2;
		s2 = s1;
		
		// Rectangle r1 = (Rectangle) new Shape();
		// r1.setBackground(); // error
		
		// Conclusion: Goal of polymorphism with object
		// 1. Easy modify data type of object 
		// 2. Hide the way create object >> factory pattern
		
		// factory-pattern: initial design pattern
		// hide object creation
		
		// collections: fixed-size, list
		// list<Student>
		// Max: 10students. int[] students = new int[10]; // fixed-size
		//    : 30students        students           30 
		//      100               students      
		
		// rectangle = square; no-relationship
		// square = rectangle; no-relationship
		
		// compile time: CP
		// runtime: RT
		// s1: CT: Shape, RT: Rectangle
		// s1: CT: Shape, RT: Square
	}
}
