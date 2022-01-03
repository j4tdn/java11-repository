package utils;

import java.util.List;

public class HibernateUtils {

	private HibernateUtils() {
	}

	public static void breakLine(String text) {
		System.out.println("\n/////===========>> " + text + " <<==========/////\n");
	}

	public static <E> void print(List<E> emplements) {
		for (E e : emplements) {
			System.out.println(e);
		}
	}
}
