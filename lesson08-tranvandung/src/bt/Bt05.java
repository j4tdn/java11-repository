package bt;

public class Bt05 {
	public static void main(String[] args) {
		String s1 = "ABCEDEABC";
		String s2 = "ABCEDCBBCK";
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
		System.out.println("Max sub String: " + result);

	}
}
