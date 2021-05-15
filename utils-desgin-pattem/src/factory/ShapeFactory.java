package factory;

public class ShapeFactory {
	enum ShapeType {
		SQUARE,RECTANGLE
	}
	
	private ShapeFactory() {
		
	}
	
	public static Shape getShape(ShapeType type) {
		Shape shape = null;
		switch(type) {
		case SQUARE :
			shape = createSquare();
			break;
		case RECTANGLE :
			shape = createRectangle();
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
