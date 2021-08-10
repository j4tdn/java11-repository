package utils;

import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
	}
	
	public static <E> void printf(List<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
	}
}
