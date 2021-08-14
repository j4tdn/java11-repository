package utils;

import java.util.List;

public class CDUtils {
	private CDUtils() {
	}
	
	public static <E> void prinf(List<E> elements){
		for(E e: elements) {
			System.out.println(e);
		}
	}
}
