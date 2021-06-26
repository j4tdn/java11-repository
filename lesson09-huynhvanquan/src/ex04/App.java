package ex04;

public class App {
	public static void main(String[] args) {
		String s = "Welcome to JAVA10 class";
		
		System.out.println("input: " + s);
		s.replace("\\s+", " ");
		System.out.println("output: " + revert(s));
	}
	
	private static String revert(String text) {
		String s = "";
		for(CharSequence c:text.split("\\s")) {
			for(int i = c.length() - 1; i >= 0; i--) {
				s += c.charAt(i);
			}
			s += " ";
		}
		return s;
	}
}
