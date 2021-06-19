package utils;

public class JvmUtils {
	private JvmUtils() {
		
	}
	
	public static void hash(String text, String s) {
		System.out.println(text + ": " + System.identityHashCode(s));
	}
}
