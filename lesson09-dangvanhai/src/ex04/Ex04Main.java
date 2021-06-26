package ex04;

public class Ex04Main {
	public static void main(String[] args) {
		String input = "Welcome to JAVA10 class";
		System.out.println("Result: " + revert(input));
	}

	private static String revert(String s) {
		String[] a = s.split("[\\s]+");
		for (int i = 0; i < a.length; i++) {
			a[i] = new StringBuilder().append(a[i]).reverse().toString();
		}
		String result = "";
		for(String i : a) {
			result = result.concat(i).concat(" ");
		}
		return result.trim();
	}
}
