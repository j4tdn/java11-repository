package utils;

import java.util.Collection;

public class CollectionUtils {
	public CollectionUtils() {

	}
	
	public static <E> void printf(Collection<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
	}
}
