package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {

	private CollectionUtils() {
	}

	public static List<Integer> init(Integer... elements) {
		List<Integer> result = new ArrayList<>();
		result.addAll(Arrays.asList(elements));
		return result;
	}

	public static void printf(List<String> elements) {
		for (String element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	public static void show(List<Integer> elements) {
		for (Integer element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}