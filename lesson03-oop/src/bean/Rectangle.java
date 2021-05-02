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

	
	//setter
	public void setWidth(int width) {
		this.width = width;
	}
	//getter
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
		return "w" + this.width + " h" + this.height;
	}

	public static void main(String[] args) {
		Rectangle r1 = new Rectangle();
		r1.width = 10;
		r1.height = 15;
		System.out.println(r1);

		Rectangle r2 = new Rectangle(9, 7);
		System.out.println(r2);

	}

}
