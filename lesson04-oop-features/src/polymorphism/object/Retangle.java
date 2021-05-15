package polymorphism.object;


public class Retangle extends Shape {
	@Override
	void drawing() {
		System.out.println("Retangle ");
	}

	
	void setBackground() {
		System.out.println("Retangle >> setting backgroud");
	}
}
