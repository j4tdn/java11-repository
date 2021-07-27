package collection.list;

import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class Ex07 {

	public static void main(String[] args) {
		
		List<Item> items = getItems();


		Item itemA = new Item(1, 120, "A12", 120);
		Item itemB = new Item(1, 10, "A10", 100);
		Item itemC = items.get(1);



		//equal cua object khi compile ss dia chi
		System.out.println("itemA: " + items.contains(itemA));
		System.out.println("itemB: " + items.contains(itemB));
		System.out.println("itemB: " + items.contains(itemC));

		items.remove(itemB);
		System.out.println("size: " + items.size());

	}

	private static List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();

		Item item1 = new Item(1, 10, "A10", 100);
		Item item2 = new Item(2, 20, "A20", 200);
		Item item3 = new Item(3, 30, "A30", 300);
		Item item4 = new Item(1, 12, "A12", 120);

		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		return items;

	}
}
