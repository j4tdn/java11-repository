package ultils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CollectionUtils {
	private CollectionUtils() {
	}

	public static List<Integer> init(Integer... elements) {
		List<Integer> result = new ArrayList<>();
		result.addAll(Arrays.asList(elements));
		return result;
	}

	public static <E> void printf(List<E> list) {
		for (E item : list) {
			System.out.println(item);
		}
	}
	
	public static <E> void printf(Set<E> list) {
		for (E item : list) {
			System.out.println(item);
		}
	}
	
	public static void show(List<Integer> list) {
		for (Integer item : list) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
}
