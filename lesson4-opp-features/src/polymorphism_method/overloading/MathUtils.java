package polymorphism_method.overloading;

public class MathUtils {
	
	private MathUtils() {
		
	}
	
	//In a class - same name 
	//+! number of parameters
	// +! input parameters type
	
	public static int sum(int a, int b) {
		return a + b;
	}
	
	public static float sum(float a, float b) {
		return a + b;
	}
	
	public static int sum(int a, int b, int c) {
		return a + b + c;
	
	}
}