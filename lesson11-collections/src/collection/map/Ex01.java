package collection.map;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Ex01 {
	public static void main(String[] args) {

		Map<Integer, String> model = new TreeMap<>();

		model.put(92, "Quang Nam");
		model.put(43, "Da Nang");
		model.put(75, "Hue");

		String v1 = model.get(88);
		String v2 = model.getOrDefault(88, "dfvl");
		String v3 = model.get(92);
		System.out.println("v1: " + v1);
		System.out.println("v2: " + v2);
		System.out.println("v3: " + v3);

		String removedValue = model.remove(75);
		System.out.println("removedValue: " + removedValue);

		System.out.println("size: " + model.size());
	}

	private static void iteratebyvalue(Map<Integer, String> model) {

		Collection<String> collection = model.values();
		for (String item : collection) {
			System.out.println("value: " + item);
		}
	}

	private static void iteratebykey(Map<Integer, String> model) {
		Set<Integer> collection = model.keySet();
		for (Integer item : collection) {
			System.out.println("value: " + item);
		}
	}

	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entryset = model.entrySet();
		for (Entry<Integer, String> item : entryset) {
			System.out.println("key: " + item.getKey());
			System.out.println("value: " + item.getValue());
		}
	}
}
