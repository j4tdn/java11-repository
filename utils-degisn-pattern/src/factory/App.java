package factory;

import factory.ShapeFactory.ShapeType;;

public class App {

	public static void main(String[] args) {
		// 1. Shape: drawing
		// 2. Rectangle : drawing, setBorder >> extends Shape
		// 3. Square : drawing, setBorder >> extends Shape
		Shape shape = new Shape();
		Square square = new Square();
		Rectangle rectangle = new Rectangle();

		Shape s1 = new Square();
		Shape s2 = new Rectangle();
		Shape s3 = null;
		
		shape.drawing();
		square.drawing();
		rectangle.drawing();
		
		s1.drawing();
		s2.drawing();
		//s3.drawing(); NPE
		
		Square c1 = (Square) new Shape();
		Rectangle c2 = (Rectangle) new Shape();
		c1.drawing();
		c2.setBorder();
		
		// Explain: s1(Square), s2(Rectangle)
		// 1: Dynamic type
		// Project: Collection(Array(static length), ArrayList(dynamic length)): 1000 -> 10000
		s2=s1;
		s1=s2;
		
		// 2 :Factory Pattern
		Shape f1 = ShapeFactory.get(ShapeType.RECT);
		Shape f2 = ShapeFactory.get(ShapeType.SQUARE);
		
	}
}
