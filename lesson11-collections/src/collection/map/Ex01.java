package collection.map;

import java.security.Identity;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

public class Ex01 {
	public static void main(String[] args) {
		//put >> check do hashcode(key), equals(key) exists? existed => replace oldvalue: put new 
		
		//Hash map: ko quan tâm thứ tự phần tử đưa vào
//		Map<Integer, String> model = new HashMap<>();
		
		//LinkedHashMap: duy trì thứ tự các phần tử đưa vào
//		Map<Integer, String> model = new LinkedHashMap<>();
		
		//TreeMap: tự động sắp xếp theo key theo thứ tự tăng dần.
		
		Comparator<Integer> keyComp = new Comparator<Integer>() {

			@Override
			public int compare(Integer k1, Integer k2) {
				if (k1 == null) {
					return 1;
				}
				
				if (k2 == null) {
					return -1;
				}
				return k2.compareTo(k1);
			}
		};
		
		Comparator<Integer> keyComp2 = Comparator.nullsFirst(Comparator.comparing(Function.identity()));
		
		Map<Integer, String> model = new TreeMap<>(keyComp2);
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(75, "Thua Thien Hue");
		model.put(null,"Da Nang 01");
		model.put(74, "Quang Tri");
		
		String v1 = model.get(43);
		String v2 = model.get(55);
		String v3 = model.getOrDefault(88, "sdfdsaf");
		
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		
		String removeValue = model.remove(75);
		System.out.println(removeValue);
		
		System.out.println("size: " + model.size());
		iterate(model);
		iterateByValue(model);
		iterateByKey(model);
	}
	
	private static void iterateByValue(Map<Integer, String> model) {
		Collection<String> keys = model.values();
		for (String key: keys) {
			System.out.println("key: " + key);
		}
	}
	
	private static void iterateByKey(Map<Integer, String> model) {
		Set<Integer> keys = model.keySet();
		for (Integer key: keys) {
			System.out.println("key: " + key);
		}
	}
	
	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entrySet =  model.entrySet();
		for (Entry<Integer, String> entry: entrySet) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
	}
}
