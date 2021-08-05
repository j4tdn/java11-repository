package collection.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import utils.CollectionUtils;

public class Ex01 {
	public static void main(String[] args) {
		// model vehicle
		// put >> check do hashCode(key), equals(key) exists ? existed => replace
		// oldValue : put new

		Comparator<Integer> keyComp = new Comparator<>() {

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

		Map<Integer, String> model = new TreeMap<>();
		model.put(43, "Da Nang");
		model.put(92, "Quang Nam");
		model.putIfAbsent(43, "Da Nang 01");
		model.put(74, "Quang Tri");
		model.put(75, "Thua Thien Hue");

		String v1 = model.get(88);
		String v2 = model.getOrDefault(88, "dfvl");
		String v3 = model.get(92);

		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);

		String removedValue = model.remove(75);
		System.out.println("removedValue: " + removedValue);

		System.out.println("size: " + model.size());

		System.out.println("============================");

		iterate(model);

	}

	private static void iterateByValue(Map<Integer, String> model) {
		Collection<String> collection = model.values();
		for (String element : collection) {
			System.out.println("value: " + element);
		}
	}

	private static void iterateByKey(Map<Integer, String> model) {
		Set<Integer> keys = model.keySet();
		for (Integer key : keys) {
			System.out.println("key: " + key);
		}
	}

	// iterate via entry
	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entrySet = model.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
	}
}