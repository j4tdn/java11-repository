package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {
	private CollectionUtils() {
		// TODO Auto-generated constructor stub

	}
	
	// ... variables 

	public static List<Integer> init(Integer... elements) {
		List<Integer> result = new ArrayList<Integer>();

		result.addAll(Arrays.asList(elements));

		return result;
	}

	public static void pritf(List<String> elements) {
		for (String element : elements) {
			System.out.println(element + " ");
		}
	}
	
	public static void show(List<Integer> elements) {
		for (Integer element : elements) {
			System.out.print(element + " ");
		}
	}
}
