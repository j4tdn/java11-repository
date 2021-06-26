package bt03;

public class Bt03 {
	public static void main(String[] args) {
		System.out.println("Permutation");
		permutation("xyz");
	}

	public static void permutation(String s) {
		permutation("", s);
	}

	private static void permutation(String firstStr, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(firstStr);
		else {
			for (int i = 0; i < n; i++)
				permutation(firstStr + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
		}
	}
}
