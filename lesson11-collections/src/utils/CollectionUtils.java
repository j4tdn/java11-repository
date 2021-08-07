package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {
	
	private CollectionUtils() {
		
	}
	
	// ... variables
	public static List<Integer> init(Integer ... elements) {
		List<Integer> result = new ArrayList<>();
		result.addAll(Arrays.asList(elements));
		return result;
	}
	
	public static <E> void printf(List<E> elements) {
		for (E element: elements) {
			System.out.println(element);
		}
	}
	
}
