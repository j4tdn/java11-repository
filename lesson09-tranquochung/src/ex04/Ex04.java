package ex04;

public class Ex04 {
	public static void main(String[] args) {
		String s = " Welcome to JAVA10 class ";
		System.out.println(revert(s));
	}

	public static String revert(String s) {
		s = s.trim();
		s = s.replaceAll("[\\s]", " ");
		String result = "";
		String[] cutS = s.split(" ");
		for (String st : cutS) {
			StringBuilder str = new StringBuilder(st);
			result = result + " " + str.reverse().toString();
		}
		return result.trim();
	}

}
