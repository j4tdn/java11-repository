package utils;

import java.util.Collection;
import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static <E> void printf(Collection<E> elements) {
		for (E e : elements) {
			System.out.println(e);
		}
	}
}