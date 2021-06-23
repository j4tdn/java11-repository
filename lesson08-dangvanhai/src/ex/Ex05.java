package ex;

public class Ex05 {
	public static void main(String[] args) {
		String s1 = "ABCEDEABC";
		String s2 = "AZCVABCEDCBBCK";
		System.out.println(lcs(s1, s2));
	}

	private static String lcs(String s1, String s2) {
		if (s1.length() > s2.length()) {
			s1 = s1 + s2;
			s2 = s1.substring(0, s1.length() - s2.length());
			s1 = s1.substring(s2.length());
		}
		String result = "";
		for (int i = 0; i < s1.length() - 1; i++) {
			for (int j = i + 1 + result.length(); j < s1.length(); j++) {
				if (s2.contains(s1.subSequence(i, j)) && result.length() < j - i) {
					result = s1.substring(i, j);
				}
			}
		}
		return result.length() > 0 ? result : null;
	}
}
