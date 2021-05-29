package functional;

public interface Printable {
	void print(String s);

	void sysout(String s1, String s2);

	default void print(int a) {
		System.out.println("a2" + (a * 2));
	}
}
