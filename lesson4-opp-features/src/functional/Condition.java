package functional;

@FunctionalInterface
public interface Condition {
	//stategy
	boolean test(int a);
	
// functional interface chi co duy nhat 1 ham truu tuong	
//	boolean cal(int a, int b);
	
	default int sum(int a, int b) {
		return a+b; 
	}
	
	static int sub(int a, int b) {
		return a-b;
	}
	
}
