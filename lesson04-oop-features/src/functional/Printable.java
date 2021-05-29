package functional;

@FunctionalInterface
public interface Printable {
	void print(String s);

	default void print(int a) {
		System.out.println("a2: " + a * 2);
	}
}
