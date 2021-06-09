package polymorphism.object;

import polymorphism.object.ShapeFactory.ShapeType;

public class App {

	public static void main(String[] args) {
		Shape shape = new Shape();
		Square square = new Square();
		Rectangle rectangle = new Rectangle();
		
		// Parent: new Child
		Shape s1 = new Square();
		Shape s2 = new Rectangle();
		// shape s3 = null;
		shape.drawing();
		square.drawing();
		rectangle.drawing();
		
		
		s1.drawing();
		s2.drawing();
		// s3.drawing();
		
		// complie
		// runtune
		
		//Child: new Parent
//		Square c1 = (Square) new Shape();
//		Rectangle c2 = (Rectangle) new Shape();
//		c1.drawing();
//		c2.setBorder();
		
		s1 = s2;
		s2 = s1;
		
		// Factory Pattern
		Shape f1 = ShapeFactory.get(ShapeType.RECT);
		Shape f2 = ShapeFactory.get(ShapeType.SQUARE);
	
		f1.drawing();
		f2.drawing();
	}
}
