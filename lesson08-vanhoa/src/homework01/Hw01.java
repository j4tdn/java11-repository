package homework01;

public class Hw01 {
	public static void main(String[] args) {
		String x = "Hòa đẹp trai !!!";
		System.out.println(x);
		println(x);
		print(x);
		System.out.println();
		System.out.println(getReverse(x));
		System.out.println(getWordReverse(x));
	}
	private static void println(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	private static void print(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.print(s.charAt(i)+ " ");
		}
	}
	private static String getReverse(String s) {
		int n = s.length();
		char[] c = s.toCharArray();
		char[] result = new char[n];
		
		for(int i = 0; i < n ; i++) {
			result[i] = c[n-i-1];
		}
		return new String(result);
	}
	private static String getWordReverse(String s) {
		String[] words = s.split("\\s");
		String[] result = new String[words.length];
		
		for (int i = 0; i < words.length; i++) {
			result[i] = words[words.length - 1 - i];
		}
		return String.join(" ", result);
	}
}
