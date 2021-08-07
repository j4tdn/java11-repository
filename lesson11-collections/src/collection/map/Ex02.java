package collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex02 {
	public static void main(String[] args) {
		//pass by value hashcode, equals
		
		
		Map<Integer, String> model = new HashMap<>();
		model.put(92, "A Quang Nam");
		model.put(43, "B Da Nang");
		model.put(null, "M Khanh Hoa");
		model.put(75, "Y Hue");
		model.put(74, "Z Quang Tri");
		
		
		
		Map<Integer, String> sortedMap = sort(model);
		for(Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry);
		}
	}
		
	
	private static Map<Integer, String> sort(Map<Integer, String> model) {
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());
		
//		Comparator<Entry<Integer, String>> comparator = ( e1, e2) -> {
//				return e1.getValue().compareTo(e2.getValue());
//		};
		
		 sortedList.sort(Entry.comparingByValue());
		 
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry: sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
		
	}
}
