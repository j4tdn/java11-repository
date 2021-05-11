package polymorphsm.method.overloading;

public class MathUtils {
	private MathUtils() {

	}
	// đây được gọi là overloading

	public static int sum2So(int a, int b) {
		return a + b;
	}
	
	public static float sum2So(float a, float b) {
		return a + b;
	}

	public static int sum3So(int a, int b, int c) {
		return a + b + c;
	}

}
