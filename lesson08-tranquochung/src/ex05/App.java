package ex05;

public class App {
	public static void main(String[] args) {
		String s1 = "ABSDCEDEABC";
		String s2 = "FGKSGSABCSSSSS";
		System.out.println(subString(s1, s2));
	}

	private static String subString(String s1, String s2) {
		if (s1.length() > s2.length()) {
			String tmp = s1;
			s1 = s2;
			s2 = tmp;
		}
		String result = "";
		for (int i = 0; i < s2.length(); i++) {
			for (int j = i + 1; j < s2.length(); j++) {
				if (s1.contains(s2.substring(i, j)) && result.length() < j - i) {
					result = s2.substring(i, j);
				}
			}
		}
		return result;
	}
}
