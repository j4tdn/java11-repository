package bean;

public class Rectangle {

	// attributes
	private int width;
	private int height;

	// constructor
	public Rectangle() {

	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	// getter
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	@Override
	public String toString() {
		return "w" + this.width + " h" + this.height;
	}

}
