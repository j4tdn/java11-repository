package bean;

public class Rectangle {

	// attributes
	private int width;
	private int height;

	// constructor
	public Rectangle() {

	}

	// constructor with 2 parameters
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	
	// getter
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return "w" + width + " h" + height;
	}

	
}
