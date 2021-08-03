package collection.map;

import java.util.AbstractMap.SimpleEntry;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Ex02 {
	public static void main(String[] args) {

		Map<Integer, String> model = new HashMap<>();
		model.put(43, "A Da Nang");
		model.put(92, "X Quang Nam");
		model.put(12, "B Quang Tri");
		model.put(75, "D Thua Thien Hue");

		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		
		System.out.println("sm1: " + System.identityHashCode(sortedMap));
		
		sort(model, sortedMap);
		
		for (Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry);
		}
	}

	private static void sort(Map<Integer, String> model, Map<Integer, String> sortedMap) {
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());

		sortedList.sort(Entry.comparingByValue());

		for (Entry<Integer, String> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
	}
}
