package utils;

import java.util.Collection;

public class ExUtils {
	private ExUtils() {
	}
	
	public static <E> void printf(Collection<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
		
	}
}
