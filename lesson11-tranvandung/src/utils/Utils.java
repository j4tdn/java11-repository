package utils;

import java.util.List;
import java.util.Set;

public class Utils {
	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static void printfList(List<?> cd) {
		for (var element : cd) {
			System.out.println(element);
		}
		System.out.println();
	}

	public static void printfSet(Set<?> cd) {
		for (var element : cd) {
			System.out.println(element);
		}
		System.out.println();
	}

}
