package polymorphsm.object;

public class Rectangle extends Shape{
	@Override
	void drawing() {
		System.out.println("Rectangle >> drawing ..");
	}
	void setBackground() {
		System.out.println("Rectangle >> setting background ...");
		
	}

}
