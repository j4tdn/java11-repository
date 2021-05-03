package bean;

public class Rectangle {

	// attributes
	private int width;
	private int height;

	// default: empty constructor.
	public Rectangle() {

	}

	// constructor with 2 parameters
	public Rectangle(int width, int height) { // convention: use same words as attributes.
		// gán giá trị trong hàm Rectangle(int width, int height) cho atributes
		// phải dùng this. vì tên attributes trùng với tên biến truyền vào
		this.width = width;
		this.height = height;
	}
	
	//setter: cập nhật giá trị width height bên ngoài (package demo) cho thuộc tính width height của đối tượng rectangle
	public void setWidth(int width) { 
		this.width = width; //không bỏ this được vì tên biến truyền vào đang trùng
	}
	
	//getter: dùng để lấy giá trị bằng cách lấy r1.getWidth
	public int getWidth() {
		return width; // không cần this. vẫn được vì ko có biến truyền vào
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

}
