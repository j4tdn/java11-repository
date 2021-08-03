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
import java.util.function.Function;


public class Ex01 {
	public static void main(String[] args) {

		// random value, key can null
		// Map<Integer, String> model = new HashMap<Integer, String>();

		// keep right order of input elements
		// Map<Integer, String> model = new LinkedHashMap<Integer, String>();

		Comparator<Integer> keyComp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 == null ) {
					return -1;
				}
				if(o2 == null) {
					return 1;
				}
				return o1.compareTo(o2);
			}
		};
		
		Comparator<Integer> keyComp2 = Comparator.nullsFirst(Comparator.comparing(Function.identity()));
		
		Map<Integer, String> model = new TreeMap<Integer, String>(keyComp2);

		model.put(43, "Da Nang");
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang 01");
		model.put(74, "Quang Tri");
		model.put(75, "Thua Thien Hue");
		model.put(null, "undentified");

		String v1 = model.get(43);
		String v2 = model.getOrDefault(88, "abcd");
		String v3 = model.get(88);

		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);

		String revmoeValue = model.remove(75);
		System.out.println("removedValue: " + revmoeValue);

		System.out.println(model);

		iterate(model);
		System.out.println("==========================");
		iterateByKey(model);
		System.out.println("==========================");
		iterateByValue(model);
	}

	private static void iterateByValue(Map<Integer, String> model) {
		Collection<String> collection = model.values();
		for (String element : collection) {
			System.out.println("key: " + element);
		}
	}

	private static void iterateByKey(Map<Integer, String> model) {
		Set<Integer> keys = model.keySet();
		for (Integer key : keys) {
			System.out.println("key: " + key);
		}
	}

	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entrySet = model.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.print("key: " + entry.getKey());
			System.out.println("		value: " + entry.getValue());
		}
	}
}
