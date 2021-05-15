package polymorphism.object;

public class Square extends Shape {
	@Override
	void drawing() {
		System.out.println("Square >> drawing ...");
	}
	void clear() {
		System.out.println("Shape >> clearing ...");
	}
}
