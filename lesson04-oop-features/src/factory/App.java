package factory;

import factory.shapeFactory.ShapeType;

public class App {
	public static void main(String[] args) {
		
		Shape s1 = shapeFactory.getShape(ShapeType.RECTANGLE);
		s1.drawing();
		
		
		Shape s2 = shapeFactory.getShape(ShapeType.SQUARE);
		s2.drawing();
		
		
	}

}
