package bt04;

public class Bt04 {
	public static void main(String[] args) {
		System.out.println("input: Welcome    to JAVA10    class");
		String s = "Welcome    to JAVA10    class";
		System.out.println("ouput:");
		revert(s);
	}

	private static void revert(String s) {
		for (String s1 : s.split("\\s+")) {
			System.out.print(" " + (new StringBuilder().append(s1).reverse()));
		}

	}
}
