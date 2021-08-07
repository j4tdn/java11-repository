package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Integer> init(Integer ... elements) {
		List<Integer> result = new ArrayList<>();
		
		result.addAll(Arrays.asList(elements));
		
		return result;
	}
	
	public static <E> void printf(List<E> elements) {
		for (E e: elements) {
			System.out.println(e);
		}
	}

}
