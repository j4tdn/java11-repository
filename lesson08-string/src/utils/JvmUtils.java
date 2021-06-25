package utils;

public class JvmUtils {
public JvmUtils() {
}
public static void hash(String text,StringBuilder m) {
	System.out.println(text + ": " + System.identityHashCode(m));
}
}
