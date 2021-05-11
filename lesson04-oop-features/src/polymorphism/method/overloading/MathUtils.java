package polymorphism.method.overloading;

public class MathUtils {

	private MathUtils() {
		
	}
	
	public static int sum2SO(int a, int b) {
		return a + b;
	}
	public static float sum2SO(float a, float b) {
		return a + b;
	}
	public static int sum3So(int a, int b, int c) {
		return a + b + c;
	}
	
}

