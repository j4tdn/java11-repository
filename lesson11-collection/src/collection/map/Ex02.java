package collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Ex02 {
	public static void main(String[] args) {
		
	Map<Integer, String> model = new HashMap<>();
	model.put(92, "Quang Nam");
	model.put(43, "Da Nang");
	model.put(43, "Da Nang 01");
	model.putIfAbsent(43, "Da Nang 02");
	model.put(75, "Thua Thien Hue");
	model.put(74, "Quang Tri");
	
	model =  sort(model);
	for(Entry<Integer, String> entry : model.entrySet()) {
		System.out.println(entry);
	}
	
	}
	
	private static Map<Integer, String> sort(Map<Integer, String> model) {
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());
		sortedList.sort(Entry.comparingByKey());
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
		
	}
}
