package polymorphism.object;

public class Rectangle extends Shape {
	@Override
	void drawing() {
		System.out.println("Rectangle >> Drawing ... ");
	}
	
	//foreground, color:text color
	//background
	void setBackground() {
		System.out.println("Rectangle >> setting background");
	}
}
