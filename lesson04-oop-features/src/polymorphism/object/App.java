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
		
		System.out.println("==============");
		Shape s1 = new Rectangle();
	    s1.drawing();
	    System.out.println("RT: " + s1.getClass().getName());
		
		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RT: " + s2.getClass().getName());
		
		s1 = s2;
		s2 = s1;
		
//	    Rectangle r1 = (Rectangle) new Shape(); 
//		Hàm cha new hàm con thì được nhưng hàm con không thể new hàm cha 
//		r1.setBackground();	 error	
		
		
		// Conclusion: Goal of polymorphism with object
		// 1. Easy modify data type of object
		// 2. Hide the way creat object >> factory-pattern
		
		// factory-pattern: init design pattern
		// hide object creational
		
		// Compile time: CT
		// Runtime: RT
		// s1: CT: Shape, RT: Rectangle
		// s2: CT: Shape, RT: Square
		
//		rectangle = square;  no-relationship
//		square = rectangle;  no-relationship
		
	}
}
