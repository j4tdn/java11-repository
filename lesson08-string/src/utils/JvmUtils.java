package utils;

public class JvmUtils {
	
	private JvmUtils() {
		
	}
	
	public static void hash(String text, String i) {
		System.out.println(text + ": "+System.identityHashCode(i));
	}

}
