package factory;

public class shapeFactory {

	enum ShapeType {
		SQUARE, RECTANGLE
	}

	private shapeFactory() {
	}

	public static Shape getShape(ShapeType type) {
		Shape shape = null;
		switch (type) {
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

	private static Square createSquare() {
		return new Square();
	}

	private static Rectangle createRectangle() {
		return new Rectangle();
	}

}
