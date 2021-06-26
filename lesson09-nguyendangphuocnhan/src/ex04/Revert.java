package ex04;

public class Revert {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		System.out.println("input: " + s);
		revert(s);
	}

	static void revert(String s) {
		String revert = "";
		int length = s.length();
		for (int i = length - 1; i >= 0; i--)
			revert = revert + s.charAt(i);
		System.out.println("output: " + revert);
	}
}
