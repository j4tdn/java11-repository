package bean;

public class Rectangle {
	// attributes
	private int width;
	private int height;

	// default: empty constructor
	public Rectangle() {

	}

	// constructor with 2 parameters
//	public Rectangle(int width, int height) {
//		this.width = width;
//		this.height = height;
//	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "w" + this.width + " h" + this.height;
	}

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}
	
}
