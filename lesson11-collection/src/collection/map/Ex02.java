package collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex02 {
	public static void main(String[] args) {
		Map<Integer, String> model = new HashMap<>();
		model.put(92, "X Quang Nam");
		model.put(43, "A Da Nang");
		model.put(75, "D Thua Thien Hue");
		model.put(74, "B Quang Tri");
		
		Map<Integer, String> sortedMap = sort(model);
		
		for(Entry<Integer, String> entry: sortedMap.entrySet()) {
			System.out.println(entry);
		}
	}

	private static Map<Integer, String> sort(Map<Integer, String> model) {
		List<Entry<Integer, String>> sortedlist = new LinkedList<>(model.entrySet());
		sortedlist.sort(Entry.comparingByValue());
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		
		for (Entry<Integer, String> entry: sortedlist) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
