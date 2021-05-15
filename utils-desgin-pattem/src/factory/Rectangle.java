package factory;


public class Rectangle  extends Shape{
	@Override
	void drawing() {
		System.out.println("Rectangle >> drawing");
	}
	
	// foreground, color : text 
	// background : mau nen
	void setBackground() {
		System.out.println("Rectangle >> setting background");
	}
}
