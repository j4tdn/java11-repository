package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bean.Item;

public class Ex07 {
	public static void main(String[] args) {

		List<Item> items = getItems();
		Item itemA = new Item(1, 2, "A12", 12);
		Item itemB = new Item(1, 10, "A10", 100);
		Item itemC = items.get(2);

		// Implementation note: List<E> elements
		// Need call: remove, contains
		// require: E override equals methods
		// Without: using default object's equals to comparing address in heap memory

		System.out.println("itemA exitsts: " + items.contains(itemA));
		System.out.println("itemB exitsts: " + items.contains(itemB));
		System.out.println("itemC exitsts: " + items.contains(itemC));

		items.remove(itemB);
		System.out.println(items.size());

	}

	private static List<Item> getItems() {
		List<Item> items = new LinkedList<>();

		Item item1 = new Item(1, 10, "A10", 100);
		Item item2 = new Item(2, 20, "A20", 300);
		Item item3 = new Item(3, 30, "A30", 400);
		Item item4 = new Item(4, 40, "A40", 100);

		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		return items;
	}

}
