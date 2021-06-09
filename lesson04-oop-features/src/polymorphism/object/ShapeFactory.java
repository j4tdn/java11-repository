package polymorphism.object;

public class ShapeFactory {
	
	enum ShapeType{
		SQUARE, RECT
	}
	
	private ShapeFactory() {
		
	}
	
	// Create object with exposing creation logic
	public static Shape get(ShapeType st) {
		Shape shape = null;
		switch (st) {
		case SQUARE:
			shape = new Square();
			break;
		case RECT:
			shape =new Rectangle();
			break;
		default:
			shape = new Shape();
		}
		return shape;
	}
}
