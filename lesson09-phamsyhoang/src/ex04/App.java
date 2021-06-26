package ex04;

public class App {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		System.out.println("Input: " + s);
		System.out.println("Output: " + revert(s));
	}

	private static String revert(String s) {
		StringBuilder str = new StringBuilder(s);
		String s2 = str.reverse().toString();
		String s1 = s2.replaceAll("\\s+", " ");
		String[] words = s2.split(" ");
		String s3 = "";
		for (int i = words.length - 1; i >= 0; i--) {
			s3 += words[i] + " ";
		}
		return s3;

	}

}
