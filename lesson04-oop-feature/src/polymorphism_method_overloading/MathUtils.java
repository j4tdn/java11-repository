package polymorphism_method_overloading;

public class MathUtils {
	
	public MathUtils() {
		
	}
	
	public static int sum (int a, int b) {
		return a + b;
	}
	
	public static float sum (float a, float b) {
		return a + b;
	}
	
	public static int sum (int a, int b, int c) {
		return a + b +c;
	}
}
