package collection.map;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Ex02 {
	public static void main(String[] args) {
		Map<Integer, String> model = new HashMap<Integer, String>();

		model.put(43, "A Da Nang");
		model.put(92, "X Quang Nam");
		model.put(43, "B Da Nang 01");
		model.put(74, "D Quang Tri");
		model.put(75, "H Thua Thien Hue");
		model.put(null, "M undentified");

		model = sort(model);
		for (Entry<Integer, String> entry : model.entrySet()) {
			System.out.println(entry);
		}

	}

	private static Map<Integer, String> sort(Map<Integer, String> model) {
		List<Entry<Integer, String>> sortedList = new LinkedList<>(model.entrySet());
		sortedList.sort(Entry.comparingByValue());

		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();

		for (Entry<Integer, String> entry : sortedList) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}
}
