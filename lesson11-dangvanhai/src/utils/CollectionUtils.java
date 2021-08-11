package utils;

import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
	}

	public static <T> void printf(List<T> list) {
		for (T t : list) {
			System.out.println(t);
		}
	}
}
