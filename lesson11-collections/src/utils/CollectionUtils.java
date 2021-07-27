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
	
	public static void printf(List<String> elements) {
		for (String e: elements) {
			System.out.println(e);
		}
	}
	public static void show(List<Integer> elements) {
		for (Integer e: elements) {
			System.out.println(e);
		}
	}
}
