package ex05;

public class Ex05 {
	public static void main(String[] args) {
		String s1 = "ABCEDEABC";
		String s2 = "ABCEDCBBCK";

		String result = "";
		for (int i = 0; i <= s2.length(); i++) {
			for (int j = i + 1; j <= s2.length(); j++) {
				if (s1.contains(s2.substring(i, j)) && result.length() < j - i) {
					result = s2.substring(i, j);
				}
			}
		}
		System.out.println("Xau con chung dai nhat cua " 
		       + s1 + " va " + s2 + " la : " + result);
	}
}
