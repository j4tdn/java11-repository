package factory;

public class Square  extends Shape{
	void drawing() {
		System.out.println("Shape >> drawing");
	}
	
	private void clear() {
		System.out.println("Shape >> clearing ... ");
	}
}
