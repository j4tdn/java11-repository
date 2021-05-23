package bean;


/** OOP - Theory
 * System = &Objects
 * Object = &Atriibutes + &Methods
 *
 * OOP - In essence
 * System = &Objects
 * Object = &Atriibutes + &Methods
 * 
 * Class > create Objects
 * Class = &Atttributes + %Methods
 * Object = Value       + Value
 */

public class Box {
	// Attributes
	private int width;
	private int height;
	
	public Box() {
	
	}
	
	public Box(int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	// Permission to access(set|get)
	// setter
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	// getter
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	
	@Override
	public String toString() {
		return "w" + width + ", h" + height;
	}
}
