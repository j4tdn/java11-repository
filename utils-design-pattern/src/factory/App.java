package factory;

import factory.ShapeFactory.ShapeType;

public class App {
	public static void main(String[] args) {
		Shape s1 = ShapeFactory.getShape(ShapeType.SQUARE);
		Shape s2 = ShapeFactory.getShape(ShapeType.RECTANGLE);
		s1.drawing();
		s2.drawing();
		
	}
}
