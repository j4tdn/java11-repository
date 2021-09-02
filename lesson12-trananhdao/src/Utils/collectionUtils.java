package Utils;

import java.util.Collection;

public class collectionUtils {
	private collectionUtils() {
		
	}
	public static <E> void Printf(Collection<E> elements) {
		elements.stream().forEach(System.out::println);
	}
}
