package collection.map;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;

public class Ex01 {
	public static void main(String[] args) {
		// model vehicle

		// Hash Map
		// LinkedHashMap: keep right order of input elements
		// TreeMap: Automatically sorted by Key Ascending

		Comparator<Integer> keyComp2 = Comparator.nullsFirst(Comparator.comparing(Function.identity()));
		Map<Integer, String> model = new TreeMap<>(keyComp2);

		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.putIfAbsent(43, "Da Nang 1");
		model.put(null, "Undetify");
		model.put(75, "Thua Thien Hue");
		model.put(74, "Quang Tri");

		String v1 = model.get(88);
		String v2 = model.getOrDefault(88, "Default");
		String v3 = model.get(88);

		String removedValue = model.remove(75);
		System.out.println("Removed Value: " + removedValue);

		System.out.println("size: " + model.size());

		System.out.println("====================");
		iterateByKey(model);
		System.out.println("====================");
		iterateByValue(model);
	}

	private static void iterateByKey(Map<Integer, String> model) {
		Collection<Integer> keys = model.keySet();
		for (Integer key : keys) {
			System.out.println("value:" + key);
		}
	}

	private static void iterateByValue(Map<Integer, String> model) {
		Collection<String> collection = model.values();
		for (String element : collection) {
			System.out.println("value:" + element);
		}
	}

	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entrySet = model.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			System.out.println("key: " + entry.getKey());
			System.out.println("value: " + entry.getValue());
		}
	}
}
