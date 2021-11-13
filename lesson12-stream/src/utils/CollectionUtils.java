package utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class CollectionUtils {
	
	private CollectionUtils() {
		
	}
	public static <E> void printf(Collection<E> elements) {
		for(E element: elements) {
			System.out.println(element + " ");
		}
	}
	public static <T, R> Set<R> map(List<T> ts, Function<T, R> func){
		Set<R> result = new HashSet<>();
		for(T t: ts) {
			result.add(func.apply(t));
		}
		return result;
	}
	
}