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

		System.out.println("===========");
		Shape s1 = new Rectangle();
		s1.drawing();
		System.out.println("RT: " + s1.getClass().getName());
		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RT: " + s2.getClass().getName());
		
		s1 = s2;
		s2 = s1;
		//Rectangle r1 = (Rectangle) new Shape(); err
		//r1.setBackground(); 
		
		//Conclusion: Goal of polymorphism with object
		//1. Easy modify data type of object
		//2. Hide the way create object >> factory pattern
		
		
		//rectangle = square; no-relationship
		//square = rectangle; no-relationship
		
		//factory-pattern: initial design pattern
		//hide object creation
		
		//collections: fixed-size,list
		//List<Student>
		//Max: 10students.int[] students = new int[10]; //fixed-size
		//	 : 30students       students
		//   : 100students      students
		
		// Compile time: CT
		// Runtime: RT
		// s1: CT: Shape , RT: Rectangle
		// s2: CT: Shape , RT: Square
	}
}
