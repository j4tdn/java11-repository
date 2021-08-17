package utils;

import java.util.List;

public class ListUtils {

	public ListUtils() {
		// TODO Auto-generated constructor stub
	}
	public static <T> void printfList(List<T> list) {
		for(T i : list) {
			System.out.println(i.toString());
		}
	}
}
