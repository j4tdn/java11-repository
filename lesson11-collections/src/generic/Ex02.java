package generic;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Float> floatList = Arrays.asList(1f, 2f, 3f, 4f, 5f);
		List<Double> doubleList = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<String> stringList = Arrays.asList("a", "b", "c", "d", "e");
		List<Object> objectList = Arrays.asList(1, "a", 2f);
		// printf(intList);
		// printf(floatList);
		// printf(doubleList);
		printf(stringList);

		printf2(5); // auto boxing
		printf2("");
	}

	private static <E> void printf2(E e) {
		System.out.println(e);
	}

	private static <E extends CharSequence> void printf(List<E> elements) {
		for (Object element : elements) {
			System.out.println(element + " ");
		}
		System.out.println();
	}
}
