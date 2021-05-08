package bean;

public class Rectangle {
	//attribute
	private int width;
	private int height;
	// default: empty constructor
	public Rectangle() {
		
	}
	// constructor with 2 parameter
	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	//setter
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
		return height;
	}
	
	public String toString() {
		return "w" + this.width + " h" + this.height;
	}
	
    //class, object
	//constructor: create o nho o heap, getter: get value, setter: update value.
	//this, toString.
}
      