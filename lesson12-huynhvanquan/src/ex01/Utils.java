package ex01;

import java.util.List;

public class Utils {
	private Utils() {};
	
	public static <T> void printf(List<T> list) {
		list.forEach(System.out::println);
	}
	
}
