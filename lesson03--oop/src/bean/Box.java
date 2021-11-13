package bean;
/** OOP - theory
 * System = &Objects
 * Object = &Attributes + %Methods
 *
 * OOP - In essence
 * System = &Objects
 * Object = &Attributes + %Methods
 * 
 * Class -> create Objects
 * Class = &Attributes + %Methods
 * Object = Value +		+Value
 */
public class Box {
	//Attributes
	private int Width;
	private int Height;
	//Empty constructor
	public Box() {
		
	}
	public Box(int width, int height) {
		Width=width;
		Height = height;
	}
	// Permission to access(get|set) attributes's value
	//setter
	public void setWidth(int width) {
		Width = width;
	}
	public void setHeight(int height) {
		Height = height;
	}
	//getter
	public int getWidth() {
		return Width;
	}
	public int getHeight() {
		return Height;
	}
	@Override
	public String toString() {
		return "w " + Width +", h "+ Height;
	}
}
