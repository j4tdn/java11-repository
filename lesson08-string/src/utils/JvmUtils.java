package utils;

public class JvmUtils {
	private JvmUtils() {
		
	}
	
	public static void hash(String text, Object s) {
		System.out.println(text + ": " + System.identityHashCode(s));
	}
}
