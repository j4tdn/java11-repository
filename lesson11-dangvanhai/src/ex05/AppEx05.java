package ex05;

import java.util.Comparator;

import utils.CollectionUtils;

public class AppEx05 {
	public static void main(String[] args) {
		// Put
		ExpenseNote expenseNote = new ExpenseNote();
		expenseNote.put("Premiom on common stock", 75000);
		expenseNote.put("Net income", 53000);
		expenseNote.put("Retained earnings", 245000);
		expenseNote.put("Deferred income taxes", 45000);
		expenseNote.put("Current liabilities", 112000);
		expenseNote.put("Long-term debt", 25000);
		expenseNote.put("Common stock", 80000);
		expenseNote.put("Preferred stock", 53000);
		System.out.println("======= Put data ========");
		CollectionUtils.printf(expenseNote.getList());
		System.out.println("Size: " + expenseNote.size());

		// Get
		System.out.println("======= Get data ========");
		System.out.println("Get Common stock: " + expenseNote.get("Common stock"));
		System.out.println("Get mock value: " + expenseNote.get("Mock value"));

		// ContainsKey
		System.out.println("======== Contains Key ========");
		System.out.println("Contains Common stocks: " + expenseNote.contrainsKey("Common stock"));
		System.out.println("Contains mock value: " + expenseNote.contrainsKey("Mock value"));

		// Remove
		System.out.println("======= Remove ========");
		System.out.println("Remove Common stock:" + expenseNote.remove("Common stock"));
		System.out.println("Remove Long-term debt: " + expenseNote.remove("Long-term debt"));
		System.out.println("Remove mock value: " + expenseNote.remove("Mock value"));

		// Size
		CollectionUtils.printf(expenseNote.getList());
		System.out.println("Size: " + expenseNote.size());

		// Filter by Function interface
		System.out.println("========== Filter: (Value > 100.000 VND) ============");
		CollectionUtils.printf(expenseNote.getList(o -> o.getValue() > 100000));

		// Sorting by Comparator interface
		System.out.println("========== Sorting by Key ============");
		CollectionUtils.printf(expenseNote.getList(Comparator.comparing(Data::getKey)));
		System.out.println("Size: " + expenseNote.size());

		System.out.println("========== Sorting by Value ============");
		CollectionUtils.printf(expenseNote.getList(Comparator.comparing(Data::getValue)));
		System.out.println("Size: " + expenseNote.size());
	}
}
