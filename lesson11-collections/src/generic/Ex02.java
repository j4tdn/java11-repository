package generic;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Float> floatList = Arrays.asList(1f, 2f, 3f, 4f, 5f);
		List<Double> doubleList = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<String> stringList = Arrays.asList("a", "b", "c", "d", "e");
		List<Number> numberList = Arrays.asList(1, 1d, 1f);
		List<CharSequence> charsList = Arrays.asList("x", "y", "z");

		printf(intList);
		printf(floatList);
		printf(doubleList);
		printf(stringList);

		printf2(5); // auto boxing
		printf3(intList);
	}

	private static <E> void printf2(E e) {

	}

	// ? willcard
	private static void printf3(List<? super Integer> elements) {
		for (Object element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

	// E generic type
	private static <E> void printf(List<E> elements) {
		for (Object element : elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}