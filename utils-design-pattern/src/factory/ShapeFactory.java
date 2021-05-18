package factory;

public class ShapeFactory {
	enum ShapeType {
		SQUARE, RECTANGLE
	}
	private ShapeFactory() {
		
	}
	public static Shape getShape(ShapeType type) {
		Shape shape = null;
		switch(type) {
		case SQUARE:
			shape = createSquare();
			break;
		case RECTANGLE: 
			shape = createRectangle();
			break;
		default:
			shape = new Shape();
		}
		return shape;
	}
	public static Square createSquare() {
		return new Square();
	}
	
	public static Rectangle createRectangle() {
		return new Rectangle();
	}
}
