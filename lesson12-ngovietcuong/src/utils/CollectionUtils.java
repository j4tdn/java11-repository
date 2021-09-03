package utils;

import java.util.Collection;

public class CollectionUtils {
	private CollectionUtils() {
	}

	public static <T> void printf(Collection<T> elements) {
		elements.forEach(System.out::println);
		System.out.println();
	}
}
