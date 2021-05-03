package bean;

public class Rectangle {
	// attributes
	private int width;
	private int height;

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
	// getter 
	public int getWidth() {
		return width;
		
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "w " + this.width + " h " + this.height;
	}
}
