package ex04;

public class SpaceAndReverseString {
	public static void main(String[] args) {
		String line = "Welcome to JAVA10 class";

		revertString(line);
	}

	private static String revertString(String line) {
		String string = line;
		string = string.replaceAll("[,\\s]+", " ").trim();
		String[] words = string.split(" ");

		string = "";

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String revertWord = "";
			for (int j = word.length() - 1; j >= 0; j--) {
				revertWord += word.charAt(j);
			}

			string = string + revertWord + " ";

		}
		System.out.println(string);

		return string;
	}
}
