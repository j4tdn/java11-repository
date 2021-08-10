package utils;

import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static <E> void printf(List<E> elements) {
		for (E e: elements) {
			System.out.println(e);
		}
	}
}
