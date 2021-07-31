package generic;

import java.util.Arrays;
import java.util.List;

public class Ex02 {
	public static void main(String[] args) {
		List<Integer> intList    = Arrays.asList(1, 2, 3, 4, 5);
		List<Float>   floatList  = Arrays.asList(1f, 2f, 3f, 4f, 5f);
		List<Double>  doubleList = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<String>  stringList = Arrays.asList("a", "b", "c", "d", "e");
		List<Number> numberList = Arrays.asList(1, 1d, 1f);
		List<CharSequence> charsList = Arrays.asList("x", "y");
		
		printf(stringList);
		printf(charsList);
		printf2(5);
		printf2("");
		printf2(intList);
		printf2(floatList);
		printf2(doubleList);
		printf2(numberList);
	}
	
	// E: generic type 
	// ?: wildcard
	// extends super
	private static void printf3(List<? super Integer> elements) {
		for (Object element: elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	private static <E> void printf2(E e) {
		System.out.println(e);
	}
	
	private static <E extends CharSequence> void printf(List<E> elements) {
		for (Object element: elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
