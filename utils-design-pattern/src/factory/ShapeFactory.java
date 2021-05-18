package factory;

public class ShapeFactory {
	enum ShapeType {
		SQUARE, RECTANGLE
	}

	private ShapeFactory() {

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

	private static Shape createRectangle() {
		return new Rectangle();
	}

	private static Shape createSquare() {
		return new Square();
	}
}
