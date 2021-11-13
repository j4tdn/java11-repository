package collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex02 {
	public static void main(String[] args) {
		Map<Integer, String> model = new HashMap<>();
		model.put(92, "A Da Nan");
		model.put(43, "B Da Nang");
		model.put(75, "C Hue");
		iterate(model);
	}

	private static Map<Integer, String> sort(Map<Integer, String> model) {
		List<Entry<Integer, String>> list = new ArrayList<>(model.entrySet());
		list.sort(Entry.comparingByValue());
		Map<Integer, String> entries = new LinkedHashMap<>();
		for (Entry<Integer, String> item : list) {
			entries.put(item.getKey(), item.getValue());
		}
		return entries;
	}

	private static void iterate(Map<Integer, String> model) {
		Set<Entry<Integer, String>> entryset = model.entrySet();
		for (Entry<Integer, String> item : entryset) {
			System.out.println("key: " + item.getKey());
			System.out.println("value: " + item.getValue());
		}
	}
}
