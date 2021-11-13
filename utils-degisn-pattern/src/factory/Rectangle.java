package factory;

public class Rectangle extends Shape {
	@Override
	public void drawing() {
		System.out.println("Rectangle >> drawing ...");
	}

	void setBorder() {
		System.out.println("Rectangle >> setBorder ...");
	}
}
