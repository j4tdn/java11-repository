package utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class CollectionUtils {
	private CollectionUtils() {
	}
	
	public static <E> void printf(Collection<E> elements) {
		for(E e : elements) {
			System.out.println(e);
		}
	}
	
	public static <T, R> Set<R> map(List<T> inventory, Function<T, R> func) {
		Set<R> result = new HashSet<>();
		for (T apple : inventory) {
			result.add(func.apply(apple));
		}
		return result;
	}
}
