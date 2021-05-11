package polymorphism.method.overloading;

public class MathUtils {
	private MathUtils() {

	}

	//in a class - same name
	// +! number of parameters
	// +! input parameter type
	public static int sum(int a, int b) {
		return a + b;
	}

	public static int sum(int a, int b, int c) {
		return a + b + c;
	}
}
