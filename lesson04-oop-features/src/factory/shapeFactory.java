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

	private static Shape createSquare() {
		// TODO Auto-generated method stub
		return new Square();
	}

	private static Shape createRectangle() {
		// TODO Auto-generated method stub
		return new Rectangle();
	}

}
