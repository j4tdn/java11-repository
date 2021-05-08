package bean;

public class Rectangle {
	private int width;
	private int height;
	
	public Rectangle() {
		// TODO Auto-generated constructor stub
	}
	
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public String toString() {
		return "[width:" + width + ", Height:" + height + "]";
	}
	
}
