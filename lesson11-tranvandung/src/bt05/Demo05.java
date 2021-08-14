package bt05;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo05 {
	public static void main(String[] args) {
		Map<String, Integer> expense = new HashMap<>();
		expense.put("Apple", 10000);
		expense.put("Tree", 350000);
		expense.put("Vegetable", 104000);
		expense.put("Water", 207000);
		expense.put("Food", 428000);
		expense.put("House", 1324000);
		expense.put("Light", 970000);
		expense.put("Eletric", 849000);

		System.out.println("1:Table Expenditure elder 500.000VND");
		getExpense(expense);
		System.out.println("==================================");

		System.out.println("2:Table Expenditure Sort With ExpenseName");
		sortName(expense);
		System.out.println("==================================");

		System.out.println("3:Table Expenditure Sort With Money Decrease");
		sortMoney(expense);

	}
	
	// find Expenditure elder 500.000VND
	private static void getExpense(Map<String, Integer> expense) {
		Set<Entry<String, Integer>> entrySet = expense.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() > 500000) {
				System.out.println("Name: " + entry.getKey());
				System.out.println("Money: " + entry.getValue() + " VND");
			}
		}
	}

	// Sort Expenditure With ExpenseName
	private static void sortName(Map<String, Integer> expense) {
		List<Entry<String, Integer>> list = new ArrayList<>(expense.entrySet());
		list.sort(Entry.<String, Integer>comparingByKey());

		for (Entry<String, Integer> entry : list) {
			System.out.println("Name: " + entry.getKey());
			System.out.println("Money: " + entry.getValue() + " VND");
		}
	}

	// Sort Expenditure With Money Decrease
	private static void sortMoney(Map<String, Integer> expense) {
		List<Entry<String, Integer>> list = new ArrayList<>(expense.entrySet());
		list.sort(Entry.<String, Integer>comparingByValue().reversed());

		for (Entry<String, Integer> entry : list) {
			System.out.println("Name: " + entry.getKey());
			System.out.println("Money: " + entry.getValue() + " VND");
		}
	}
}
