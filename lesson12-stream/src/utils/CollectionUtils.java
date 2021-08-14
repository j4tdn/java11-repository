package utils;

import java.util.List;

public class CollectionUtils {
	public static void main(String[] args) {
		
	}
	
	public static <E> void printf(List<E> elements) {
		for	(E element: elements) {
			System.out.println(element);
		}
	}
}
