package collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex02 {

	public static void main(String[] args) {
		Map<Integer,String> model = new HashMap<>();
		model.put(92, "A Quang Nam");
		model.put(43, "X Da Nang");
		model.put(75, "B T.T Hue");
		model.put(74, "D Quang Tri");
		
		Map<Integer, String> sortedMap = sort(model);
		for(Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry);
		}
		
	}
	private static Map<Integer,String> sort(Map<Integer,String> model) {
		List<Entry<Integer,String>> sortedList = new LinkedList<>(model.entrySet());
		sortedList.sort(Entry.comparingByValue());
		
		Map<Integer,String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry: sortedList) {
			sortedMap.put(entry.getKey(),entry.getValue());
		}
		
		return sortedMap;
	}
}