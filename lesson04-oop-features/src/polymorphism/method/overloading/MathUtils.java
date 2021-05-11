package polymorphism.method.overloading;

public class MathUtils {
 
	private MathUtils() {
	 
 }
	
	// In a class - same method name
	// + ! number of parameters
	// + ! input parameters types
 
 public static int sum(int a, int b) {
	 return a + b;
 }

 public static float sum(float a, float b) {
	 return a + b;
 }
 
 public static int sum(int a, int b,int c) {
	 return a + b + c;
 }
}
