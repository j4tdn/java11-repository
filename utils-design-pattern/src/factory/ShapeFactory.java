package factory;

public class ShapeFactory {
	enum ShapeType{
		SQUARE, RECTANGLE;
	}

	private ShapeFactory() {
		
	}
	public static Shape getShape(ShapeType type) {
		Shape shape = null;
		switch(type) {
		case SQUARE:
			shape = new Square();
			break;
		case RECTANGLE:
			shape = new Shape();
	    default:
	    	shape = new Shape();

		}
		return shape;
	}

	public static Square cretateSquare() {
		return new Square();
	}
	public static Retangle createRectangle() {
		return new Retangle();
	}
	
}
