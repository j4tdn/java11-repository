package factory;

public class ShapeFactory {
	
	enum ShapeType{
		SQUARE, RECTANGLE
	}
	
	private ShapeFactory() {
		
	}
	
	public static Shape getShape(ShapeType type) {
		Shape shape = null;
		switch (type) {
		case SQUARE: {
			shape = createSquare();
		}
		case RECTANGLE: {
			shape = createRectangle();
		}
		default:
			shape = new Shape();
		}
		
		return shape;
	}
	
	private static Square createSquare() {
		return new Square();
	}
	
	private static Rectangle createRectangle() {
		return new Rectangle();
	}
}
