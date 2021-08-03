package collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex02 {
	public static void main(String[] args) {
		//pass by value
		Map<Integer, String> model = new HashMap<>();
		model.put(92, "A Quang Nam");
		model.put(43, "X Da Nang");
		model.put(75, "BThua Thien Hue");
		model.put(null," DDa Nang 01");
		model.put(74, "C Quang Tri");
//		Map<Integer, String> sortedMap = sort(model);
		model = sort(model);
		for (Entry<Integer, String> entry: model.entrySet()) {
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
