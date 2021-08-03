package collection.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

import static java.util.Comparator.*;


public class Ex01 {
	public static void main(String[] args) {
		// model vehicle
		// put >> check do hashcode(key). equals(key) exists ? existed => replace
		// oldValue: put new

		// HashMap
		// LinkedHashMap: keep right order of input elements
		// TreeMap: Automatically sorted by Key Ascending

		Comparator<Integer> keyComp = new Comparator<Integer>() {

			@Override
			public int compare(Integer k1, Integer k2) {
				if(k1 == null) {
					return -1;
				}
				if(k2 == null) {
					return 1;
				}
				return k2.compareTo(k1);
			}
		};
		Comparator<Integer> keyComp2 = nullsFirst(comparing(Function.identity()));
		
		Map<Integer, String> model = new TreeMap<>(keyComp2);
		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(null, "Null");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");

		String v1 = model.get(99);
		String v2 = model.getOrDefault(99, "dfvl");
		String v3 = model.get(75);

		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);

		String removeValue = model.remove(75);
		System.out.println("removedValue: " + removeValue);

		System.out.println("size: " + model.size());

		System.out.println("============================");
		iterate(model);
		System.out.println("============================");
		iterateByKey(model);
		System.out.println("============================");
		iterateByValue(model);
	}

	// iterate via value
	private static void iterateByValue(Map<Integer, String> model) {
		Collection<String> collection = model.values();
		for (String element : collection) {
			System.out.println("value: " + element);
		}

	}

	// iterate via key
	private static void iterateByKey(Map<Integer, String> model) {
		Set<Integer> keys = model.keySet();
		for (Integer key : keys) {
			System.out.println("key: " + key);
		}
	}

	// iterate via key and value
	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entrySet = model.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println("key:   " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
	}
}
