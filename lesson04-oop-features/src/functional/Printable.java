package functional;

@FunctionalInterface
public interface Printable {
	void print(String a);
	//void sysout(String s1, String s2);
	
	default void print(int a) {
		System.out.println("a1: " +(a*2));
	}

}
