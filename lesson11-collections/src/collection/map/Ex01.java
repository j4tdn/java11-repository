package collection.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import static java.util.Comparator.*;

public class Ex01 {
	public static void main(String[] args) {
		//List<E> elements >> contains(x), remove(x) >> equals
		
		//model vehicle: not order map: khong dam bao thu tu phan tu dc dua vao 
		// put >> check do hashcode(key), equals(key) exists ? existed => replace oldValue: put new
		
		//Hash Map
		//LinkHashMap: keep right order of input elements
		//TreeMap: Automatically sorted by key Ascending 
		
		Comparator<Integer> keyCom1 = new Comparator<Integer>() {
			
			@Override
			public int compare(Integer k1, Integer k2) {
				if(k1 == null) {
					return -1;
				}
				if(k2 == null ) {
					return 1;
				}
				return k1.compareTo(k2);
			}
		};
		
		Comparator<Integer> keyCom2 = Comparator.nullsFirst(Comparator.comparing(Function.identity()));
		
		Map<Integer, String> model = new TreeMap<>(keyCom2);
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(null, "Khanh Hoa");
		model.putIfAbsent(43, "Da Nang 01");
		model.put(75, "Hue");	
		model.put(74, "Quang Tri");
		
		String v1 = model.get(88);
		String v2 = model.getOrDefault(88, "this value not exsits ");
		String v3 = model.get(92);
		String v4 = model.get(43);
		
		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);
		System.out.println("v4: " + v4);
		
		String removeValue = model.remove(74);
		System.out.println("removed Value: " + removeValue);
		
		System.out.println("size: " + model.size() );
		
		System.out.println("============================");
		//iterate(model);
		
		System.out.println("============================");
		iterateByKey(model);
		
		System.out.println("============================");
		iterateByValue(model);
	}
	//iterate via value
		private static void iterateByValue(Map<Integer, String> model) {
		Collection<String> collection =	model.values();
		for(String element: collection) {
			System.out.println("value: " + element);
		}
		}
	
	//iterate via key
	private static void iterateByKey(Map<Integer, String> model) {
		
		Set<Integer> keys = model.keySet();
		for(Integer key : keys) {
			System.out.println("key: " + key);
		}
	}
	
	//iterate via entry
	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entrySet = model.entrySet();
		for( Entry<Integer, String> entry : entrySet) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
	}
}
