package stratery;

@FunctionalInterface
public interface Condition {
	boolean test(int a);
	
	// boolean cal(int a, int b);
	
	default int sum(int a, int b) {
		return a + b;
	}
	
	static int sub(int a, int b) {
		return a - b;
	}
}
