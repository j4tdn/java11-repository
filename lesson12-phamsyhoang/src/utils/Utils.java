package utils;

import java.util.Collection;

public class Utils {

	public Utils() {
		
	}

	public static <E> void printf(Collection<E> elements) {
		for (E e : elements) {
			System.out.println(e);
		}
	}
}