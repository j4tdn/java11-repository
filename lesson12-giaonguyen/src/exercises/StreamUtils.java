package exercises;

import java.util.Collection;

public class StreamUtils {
	private StreamUtils() {
		
	}
	
	public static <E> void printf(Collection<E> elements) {
		for (E e: elements) {
			System.out.println(e);
		}
	}
}
