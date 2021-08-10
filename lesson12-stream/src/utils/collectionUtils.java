package utils;

import java.util.List;

public class collectionUtils {
	private collectionUtils() {

	}

	public static <E> void printf(List<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
	}
}