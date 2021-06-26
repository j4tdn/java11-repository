package strategy;

@FunctionalInterface
public interface Condition {
	// strategy
	boolean test(int a);

	default int sum(int a, int b) {
		return a + b;
	}

	static int sub(int a, int b) {
		return a - b;
	}
}