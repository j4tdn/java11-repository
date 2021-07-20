package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();

		Arrays.sort(items);

		ArrayUtils.printf(items);

		Arrays.sort(items, (o1, o2) -> o1.getStoreId() - o2.getStoreId());
		System.out.println("=========================");
		ArrayUtils.printf(items);

		Comparator<Item> comparator = Comparator.comparing(Item::getStoreId);
		
		Arrays.sort(items, comparator.thenComparing(Item::getItemId).reversed());
		
//		Arrays.sort(items, Comparator.comparing(i -> i.getStoreId()));

		System.out.println("=========================");
		ArrayUtils.printf(items);
	}

	private static Item[] getItems() {
		return new Item[] { new Item(1, 12, "a", 278), new Item(2, 27, "B", 12), new Item(3, 12, "c", 278),
				new Item(2, 29, "D", 259), new Item(1, 18, "f", 278), new Item(1, 10, "K", 159),
				new Item(4, 12, "B", 47), };
	}
}
