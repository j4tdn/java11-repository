package bean;

public class Rectangle {

	// attributes
	private int width;
	private int height;

	// defailt: empty constructor
	public Rectangle() {
	}

	// ham khoi tao
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	// setter
	public void setwidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	// getter
	public int getwidth() {
		return this.width;
	}

	public int getHeight() {
		return height;
	}

	public String toString() {
		return "w" + this.width + " h" + this.height;
	}

}