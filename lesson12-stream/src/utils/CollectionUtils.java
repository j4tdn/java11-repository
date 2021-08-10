package utils;

import java.util.List;

public class CollectionUtils {
public CollectionUtils() {
}
public static <E> void printf(List<E> elements) {
	for(E e: elements) {
		System.out.println(e);
	}
}
}
