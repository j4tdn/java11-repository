package collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex02 {
	public static void main(String[] args) {
		// pass by value
		// Map<Employee, List<<Employee>> manList = new HashMap<>();
		
		Map<Integer, String> model = new HashMap<>();
		model.put(43, "Da Nang");
		model.put(92, "Quang Nam");
		model.put(12, "Quang Tri");
		model.put(74, "Thua Thien Hue");
		
		model = sort(model);
		
		for (Entry<Integer, String> entry: model.entrySet()) {
			System.out.println(entry);
		}
		
		//System.out.println("========");
		//System.out.println(sort(model));
	}
	
	private static Map<Integer, String> sort(Map<Integer, String> model) {
		// process
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());
		sortedList.sort(Entry.comparingByValue(Comparator.reverseOrder()));
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		
		for (Entry<Integer, String> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedMap;
	}
}






