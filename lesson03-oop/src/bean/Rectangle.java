package bean;

public class Rectangle {
	// attributes
	private int width;
	private int height;
	// empty constructor
	public Rectangle() {
		
	}

//	constructor with 2 parameters
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

//	setter
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

//	getter
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public String toString() {
		return "w" + width + " h" + height;
	}

}
