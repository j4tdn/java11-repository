package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionUtils {
	public CollectionUtils() {
		// TODO Auto-generated constructor stub
	}

	public static List<Integer> init(Integer... elements) {
		List<Integer> rs = new ArrayList<>();
		rs.addAll(Arrays.asList(elements));
		return rs;
	}

	public static void show(List<Integer> elements) {
		for (Integer element : elements) {
			System.out.println(element + " ");
		}
		System.out.println();
	}

	public static void printf(List<String> elements) {
		for (String element : elements) {
			System.out.println(element + " ");
		}
		System.out.println();
	}
}
