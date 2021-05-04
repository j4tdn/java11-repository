package bean;

public class Rectangle {

	// attributes
	private int width;
	private int height;

	// dèault: empty constructor
	public Rectangle() {

	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
    public int getHeight() {
		return height;
	}
    public int getWidth() {
		return width;
	}
    public void setHeight(int height) {
		this.height = height;
	}
    public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "w" + this.width + "h" + this.height;
				
	}

	public static void main(String[] args) {
	//
	Rectangle r1	= new Rectangle();
	r1.width = 12;
	r1.height = 6;
	System.out.println();
		
	}
}
