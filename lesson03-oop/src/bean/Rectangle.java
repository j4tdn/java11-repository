package bean;

public class Rectangle {
	// attributes
	private int width;
	private int height;

	// default: empty constructor
	public Rectangle() {
		super();
	}

	// constructor
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return "w" + width + " h" + height;
	}

	// setters and getters
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
	
}
