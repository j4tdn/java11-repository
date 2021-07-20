package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import bean.Item;
import untils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		Arrays.sort(items, new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getItemId() - o2.getItemId();
			}
		});
//		ArrayUtils.printf(items);

		Comparator<Item> comp2 = (Item i1, Item i2) -> {
			return i1.getItemId() - i2.getItemId();
		};

		Comparator<Item> comp3 = Comparator.comparing(new Function<Item, Integer>() {

			@Override
			public Integer apply(Item t) {
				// TODO Auto-generated method stub
				return t.getItemId();
			}
		});

		Comparator<Item> comp4 = Comparator.comparing(i -> i.getStoreId());

		// Arrays.sort(items, comp4);

		// multiple compare
		Comparator<Item> x = Comparator.comparing(i -> i.getStoreId());
		x.thenComparing(i -> i.getItemId());

		Comparator<Item> comparator = Comparator.comparing(i -> i.getStoreId());
		Arrays.sort(items, comparator.thenComparing(i -> i.getItemId(), Comparator.reverseOrder()));

		Arrays.sort(items, comparator);
		ArrayUtils.printf(items);
	}
	
	private static Item[] getItems() {
		return new Item[] { 
				new Item(1, 12, "a", 278),
				new Item(2, 27, "B", 12),
				new Item(3, 12, "c", 278),
				new Item(2, 29, "D", 259),
				new Item(1, 18, "f", 278),
				new Item(1, 10, "K", 159),
				new Item(4, 12, "B", 47), 
		};
	}
}
