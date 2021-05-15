package polymorphism.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing(); // Shape >> drawing

		Rectangle rectangle = new Rectangle();
		rectangle.drawing(); // Rectangle >> drawing
		rectangle.setBackground(); // Rectangle >> setting background

		Square square = new Square();
		square.drawing(); // Square >> drawing

		System.out.println("===============");
		Shape s1 = new Rectangle();
		s1.drawing(); // Rectangle >> drawing
		System.out.println("RTS1: " + s1.getClass().getName());

		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RTS2: " + s2.getClass().getName());

		s1 = s2;
		s2 = s1;

		// Rectangle r1 = new Shape();
		// r1.setBackground(); error

		// Conclusion: Goal of polymorphism with object
		// 1. Easy modify data type of object
		// 2. Hide the way create object >> factory

		// factory-pattern: initial design pattern
		// hide object creational

		// Collection: fixsize, list
		// List<Student>
		// Max: 10 students. int[] students = new int[10]; // fixed-size
		// : 30 studnets students 30
		// 100 students

		// rectangle = square; no-relationship
		// square = rectangle; no-relationship

		// Compile time: CT
		// Runtime: RT
		// s1: CT: Shape, RT: Rectangle
		// s2: CT: Shape, RT: Square
	}
}
