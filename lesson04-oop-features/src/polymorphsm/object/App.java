package polymorphsm.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing();
		
		Rectangle rectangle = new Rectangle();
		rectangle.drawing();
		rectangle.setBackground();
		
		Square square = new Square();
		shape.drawing();
		
		System.out.println("==============");
		Shape s1 = new Rectangle();
		s1.drawing();
		System.out.println("RTs1: "+ s1.getClass().getName());
		
		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RTs1: "+ s2.getClass().getName());
		s1 =s2;
		s2 = s1;
		
//		Rectangle r1 = (Rectangle) new Shape();
//		r1.setBackground();// khong the chay vi trong Shape khong co ham setBackground
		
		//rectangle = spare; no relationship
		// compile time
		//Runtime: RT
		//s1: CT: Shape
		// RT: Rectangle
		
		//conclusion: goal of polymorphism with object
		//1.easy modify data type of object
		//2.hide the way creat object >> factory pattern
		
		// factory pattern: initial design parttern
		//hide object creation
		
		
		
		
		
		
		
	}

}
