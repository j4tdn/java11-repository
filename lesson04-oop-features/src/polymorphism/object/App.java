package polymorphism.object;

public class App {
	public static void main(String[] args) {
		Shape shape = new Shape();
		shape.drawing();
		
		Rectangle rectangle = new Rectangle();
		rectangle.drawing();
		
		Square square = new Square();
		square.drawing();
		
		System.out.println("===============");
		
		Shape s1 = new Rectangle();
		s1.drawing();
		System.out.println("RST1 :" + s1.getClass().getName());
		
		Shape s2 = new Square();
		s2.drawing();
		System.out.println("RST2 :"  + s2.getClass().getName());
		
		s1 = s2;
		s2 = s1;
		
		// Rectangle r1 = new Shape();
		// r1.setBackground();  error
	}
}
