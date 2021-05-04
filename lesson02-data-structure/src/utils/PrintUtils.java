package utils;

public class PrintUtils {
	public static void hash(String text ,Object input) {
			System.out.println(text + ": " + System.identityHashCode(input));
			System.out.println(text + ": " + System.identityHashCode(text));
			
	}

}
