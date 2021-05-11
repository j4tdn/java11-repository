package poymorphism.method.overloading;

public class MathUtils {

	private MathUtils() {
		
	}
	
	public static float sum(float a, float b) {
		return a + b;
	}
	
	public static int sum(int a, int b, int c) {
		return a + b + c;
	}
}
