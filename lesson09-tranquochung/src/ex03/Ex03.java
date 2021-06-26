package ex03;

public class Ex03 {
	public static void main(String[] args) {
		String input = "xyz";
		permutation(input);
	}

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String s) {
		int n = s.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++)
				permutation(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, n));
		}
	}
}
