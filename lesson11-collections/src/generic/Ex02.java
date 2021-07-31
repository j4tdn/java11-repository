package generic;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Float> floatList = Arrays.asList(1f, 2f, 3f, 4f, 5f);
		List<Double> doubleList = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<Number> numberList = Arrays.asList(1, 2d, 3f, 3, 6f);

		List<String> stringList = Arrays.asList("a", "b", "c", "d", "f");
		List<CharSequence> charsList = Arrays.asList("a", "b", "c", "d", "f");
		printf(intList);
//		printf(floatList);
//		printf(doubleList);
//		printf(numberList);
//		
//		printf(stringList);
//		printf(charsList);
		printf2(5); // auto boxing
	}

	private static <E> void printf2(E e) {

	}

	// E: generic type
	// ?: wildcard
	private static void printf(List<? super Integer> elements) {
		for (var element : elements) {
			System.out.println(element + " ");
		}
		System.out.println();
	}

}
