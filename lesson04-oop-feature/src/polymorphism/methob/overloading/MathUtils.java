package polymorphism.methob.overloading;

public class MathUtils {
	private MathUtils() {
		
	}
	// in a class - same method name
	// + ! number of parameters
	// + ! input parameter type
	//==> overloading

	
	public static float sum2so(float a,float b) {
		return a + b;
	}
	public static int sum3so(int a,int b,int c) {
		return a + b + c;
	}

}
