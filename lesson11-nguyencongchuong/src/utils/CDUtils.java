package utils;

import java.util.Collection;

public class CDUtils {
	private CDUtils() {
	}
	
	public static <E> void prinf(Collection<E> elements){
		for(E e: elements) {
			System.out.println(e);
		}
	}
}
