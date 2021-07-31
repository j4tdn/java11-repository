package generic;

import java.util.Arrays;
import java.util.List;


public class Ex02 {
	public static void main(String[] args) {
		List<Integer> intList    = Arrays.asList(1, 2, 3, 4, 5);
		List<Float>   floatList  = Arrays.asList(1f, 2f, 3f, 4f, 5f);
		List<Double>  doubleList = Arrays.asList(1d, 2d, 3d, 4d, 5d);
		List<String>  stringList = Arrays.asList("a", "b", "c", "d", "e");
		List<Object>  objectList = Arrays.asList("a",1, "c", 6, "e");
		List<CharSequence>  charslist = Arrays.asList("a","c");
		
		printf1(intList);
//		printf1(stringList);
     	printf(stringList);
     	printf(charslist);
     	printf2(5);
     	
     	
	}
	
	//E: generic type

	private static <E> void printf2(E e) {
		System.out.println(e);
	}
	private static <E extends CharSequence> void printf(List<E> elements) {
		for (Object element : elements) {
			System.out.print(element+"  ");
		}
		System.out.println();
	}
	//?: wildcard
	private static  void printf1(List<? super Integer> elements) {
		for (Object element : elements) {
			System.out.print(element+"  ");
		}
		System.out.println();
	}

}
