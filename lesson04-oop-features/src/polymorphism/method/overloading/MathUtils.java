package polymorphism.method.overloading;

public class MathUtils {

	private MathUtils() {

	}

	// In a class - Same name
	// + ! number of parameters
	// + ! input parameter type
	public static int sumNumber(int a, int b) {
		return a + b;
	}

	public static float sumNumber(float a, float b) {
		return a + b;
	}

	public static int sumNumber(int a, int b, int c) {
		return a + b + c;
	}
}
