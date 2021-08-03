package collection.map;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ex02 {
	public static void main(String[] args) {
		Map<Integer, String> model = new TreeMap<>();
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>(); 
		
		sort(model,sortedMap);
		for(Entry<Integer, String> entry: sortedMap.entrySet()) {
			System.out.println(entry);
		}
	}

	private static void sort(Map<Integer, String> model,Map<Integer, String> sortedMap) {
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());
		sortedList.sort(Entry.comparingByValue());
		for (Entry<Integer, String> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
	}
}
