package utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class collectionUtils {
	private collectionUtils() {

	}

	public static <E> void printf(Collection<E> elements) {
		for (E element : elements) {
			System.out.println(element);
		}
	}
	
	public static <T,R> Set<R> map (List<T> ts, Function<T, R> function){
		Set<R> result = new HashSet<>();
		// behavior(Apple): R
		for (T t : ts) {
			// apple -> country, id ,weight
			
			result.add(function.apply(t));
		}
		return result;
	}
}