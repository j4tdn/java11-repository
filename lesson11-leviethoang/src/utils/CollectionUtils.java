package utils;

import java.util.Collection;

public class CollectionUtils {
	private CollectionUtils() {
	}
	
	public static<E> void printf(Collection<E> elements) {
		for(E e : elements) {
			System.out.println(e);
		}
	}
}
