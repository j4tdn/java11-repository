package ex05;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.function.Predicate;

public class App {
	public static void main(String[] args) {
		Map<String, Double> expenditures = getExpenditures();

		System.out.println("<<=== Expenditures more than 500k ===>>");
		iterate(filter(expenditures, e -> e.getValue() > 500d));

		System.out.println("\n<<=== Sorted Key ===>>");
		iterate(expenditures);

		System.out.println("\n<<=== Sorted Value ===>>");
		iterate(sortedValue(expenditures));
	}

	private static Map<String, Double> sortedValue(Map<String, Double> expenditures) {
		List<Entry<String, Double>> sortedList = new ArrayList<>(expenditures.entrySet());
		sortedList.sort(Comparator.nullsFirst(Entry.comparingByValue()));

		Map<String, Double> sortedMap = new LinkedHashMap<>();
		for (Entry<String, Double> e : sortedList) {
			sortedMap.put(e.getKey(), e.getValue());
		}
		return sortedMap;
	}

	private static Map<String, Double> filter(Map<String, Double> expenditures,
			Predicate<Entry<String, Double>> predicate) {
		Map<String, Double> results = new HashMap<>();
		for (Entry<String, Double> e : expenditures.entrySet()) {
			if (predicate.test(e)) {
				results.put(e.getKey(), e.getValue());
			}
		}
		return results;
	}

	private static Map<String, Double> getExpenditures() {
		Map<String, Double> expenditures = new TreeMap<>();
		expenditures.put("Điện", 500d);
		expenditures.put("Wifi", 200d);
		expenditures.put("Mặt Bằng", 7200d);
		expenditures.put("Lương Nhân Viên", 4810d);
		expenditures.put("Thuế", 500d);
		expenditures.put("Hỗ Trợ", 600d);
		expenditures.put("Thay Thế Thiết bị", 150d);
		return expenditures;
	}

	private static void iterate(Map<String, Double> expenditures) {
		for (Entry<String, Double> e : expenditures.entrySet()) {
			System.out.println(e);
		}
	}
}
