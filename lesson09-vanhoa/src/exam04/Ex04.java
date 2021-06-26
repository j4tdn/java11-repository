package exam04;

public class Ex04 {
	public static void main(String[] args) {
		String string = "Ðau lýng ghia !!!";
		System.out.println(string);
		System.out.println("==========================");
		System.out.println("result: " + revert(string));
	}

	private static String revert(String s) {
		String[] words = s.split("\\s");
		String string = "";
		for (String word : words) {
			string += word;
		}

		char[] c = string.toCharArray();
		char[] results = new char[c.length];
		int n = c.length;
		for (int i = 0; i < n; i++) {
			results[i] = c[n - i - 1];
		}
		return new String(results);
	}
}
