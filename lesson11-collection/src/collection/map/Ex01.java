package collection.map;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;
import java.util.TreeMap;

public class Ex01 {
	public static void main(String[] args) {
		// model vehicle 
		// put >> check do hashcode(key), equal(key) exists ? existed => replace oldValue :new
		// HashMap
		// LinkedHashMap : keep right order of input elements
		// TreeMap : Automatically sorted by Key Ascending
		
		
		Map<Integer, String> model = new TreeMap<>(Comparator.nullsFirst(Comparator.comparing((o1 -> o1 ))));
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(43, "Da Nang 01");
		model.putIfAbsent(43, "Da Nang 02");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");

		model.remove(43);
		
		String value1 = model.get(88);
		String value2 = model.getOrDefault(88, "Hello");
		String value3 = model.get(92);
		
		System.out.println("v1 : " + value1);
		System.out.println("v2 : " + value2);
		System.out.println("v3 : " + value3);
		
		System.out.println("size : " + model.size());
		System.out.println("===================");
		iterate(model);
		
	}
	private static void iterateByValue(Map<Integer,String> model) {
		Collection<String> collection = model.values();
		for(String element : collection) {
				System.out.println(element);
			
		}
	}
	private static void iterateByKey(Map<Integer,String> model) {
		Collection<Integer> collection = model.keySet();
		for(Integer element : collection) {
				System.out.println(element);
			
		}
	}
	// iterate via entry
	private static void iterate(Map<Integer,String> model) {
		Set<Entry<Integer, String>> set =  model.entrySet();
		for(Entry<Integer, String> entry : set) {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			
		}
		
	}
}
