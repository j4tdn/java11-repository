package utils;

public class JvmUtils {
	public JvmUtils() {

	}

	public static void hash(String text, CharSequence s) {
		System.out.println(text + ":" + System.identityHashCode(s));
	}
}
