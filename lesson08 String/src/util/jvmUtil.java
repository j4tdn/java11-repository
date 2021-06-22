package util;

public class jvmUtil {

	private jvmUtil() {
	
     }
	public static void hash(String text , CharSequence s) {
		System.out.println(text+ ": " + System.identityHashCode(s));
	}
}
