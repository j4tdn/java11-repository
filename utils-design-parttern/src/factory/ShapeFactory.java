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
			shape = creatSquare();
			break;
			
		case RECTANGLE:
			shape = creatRectangle();
			break;

		default:
			shape = new Shape();
		}
		return shape;
	}

	public static Square creatSquare() {
		return new Square();
	}

	public static Rectangle creatRectangle() {
		return new Rectangle();
	}
}
