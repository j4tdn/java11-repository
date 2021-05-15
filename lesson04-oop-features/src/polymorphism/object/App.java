package polymorphism.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing();
		
		Rectangle rectangle =  new Rectangle();
		rectangle.drawing();
		rectangle.setBackground();
		
		Square square = new Square();
		square.drawing();
		
		System.out.println("===============");
		Shape s1 = new Rectangle();
		s1.drawing(); 
		System.out.println("RTS1: " + s1.getClass().getName());
		
		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RTS2: " + s2.getClass().getName());
		
		s1 = s2;
		s2 = s1;
		
//		Rectangle r1 = (Rectangle) new Shape;
//		r1.setBackground(); 
//		
//		Concluesion: goal of polymorphism with object
//		1. ez modify data type of object
//		2. hide the way create object >> factory pattern
//		
//		factory-pattern: initial design pattern
//		hide object creation
//		
//		collection: fixed-size, list
//		List<Student>
		
		
		
	}
}
