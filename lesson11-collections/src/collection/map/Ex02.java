package collection.map;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex02 {
	
	public static void main(String[] args) {
		// pass by value. hashcode, equals
		// Map<Employee, List<Employee>> manList = new HashMap<>();
		
		Map<Integer, String> model = new HashMap<>();
		model.put(43, "A Da Nang");
		model.put(92, "X Quang Nam");
		model.put(12, "B Quang Tri");
		model.put(75, "D Thua Thien Hue");
		
		model = sort(model);
		
		for (Entry<Integer, String> entry: model.entrySet()) {
			System.out.println(entry);
		}
	}
	
	private static Map<Integer, String> sort(Map<Integer, String> model) {
		// process
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());
		sortedList.sort(Entry.comparingByValue());
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		
		for (Entry<Integer, String> entry: sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
}
