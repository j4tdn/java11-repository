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
		// pass by value. hashcode, equals
		// Map<Employee, List<Employee>> mainList = new HashMap<>();
		
		Map<Integer, String> model= new HashMap<>();
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");
		
		Map<Integer, String> sortedMap = sort(model);
		
		model = sort(model);
		for(Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry);
		}
	}
	//2h20p.note
	private static Map<Integer, String> sort(Map<Integer, String> model) {
		List<Entry<Integer, String>> sortedlist = new LinkedList<>(model.entrySet()); 

		sortedlist.sort(Entry.comparingByValue());
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry: sortedlist) {
			sortedMap.put(entry.getKey(), entry.getValue());
			}
		return sortedMap;
	} 
	
}
