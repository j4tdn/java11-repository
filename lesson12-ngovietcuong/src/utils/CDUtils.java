package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ex02.CD;

public class CDUtils {
	private CDUtils() {
	}

	public static List<CD> getAll() {
		List<CD> result = new ArrayList<>();
		
		result.add(new CD(1, "Single", "Morgan Wallen", 10, 200));
		result.add(new CD(2, "Lead Single", "Olivia Rodrigo", 12, 100));
		result.add(new CD(3, "Digital Single", "Justin Bieber", 25, 170));
		result.add(new CD(4, "Pre Release", "Taylor Swift", 18, 240));
		result.add(new CD(5, "Single", "Billie Eilish", 8, 280));
		result.add(new CD(6, "Digital Single", "Post Malone", 11, 320));
		result.add(new CD(7, "Single", "Ed Sheeran", 14, 450));
		
		return result;
	}
	
	public static <E> void printf(List<E> elements) {
		for(E element:elements) {
			System.out.println(element);
		}
	}
}
