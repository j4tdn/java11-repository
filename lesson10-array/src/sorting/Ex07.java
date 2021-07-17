package sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

import static java.util.Comparator.*;
import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		Arrays.sort(items,new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return o1.getItemId() - o2.getItemId();
			}
		});
		ArrayUtils.printf(items);
		
		System.out.println("=======");
		
		Arrays.sort(items,new Comparator<Item>() {

			@Override
			public int compare(Item o1, Item o2) {
				return Double.compare(o1.getPrice(), o2.getPrice());
			}
		});
		ArrayUtils.printf(items);
		
		Comparator<Item > comp1 = (Item o1, Item o2) ->{
			return o1.getItemId() - o2.getItemId();
		};
		
		Comparator<Item> comp2 = (o1, o2) -> o1.getItemId() - o2.getItemId();
		
		Comparator<Item> comp3 = Comparator.comparing(new Function<Item, Integer>() {

			@Override
			public Integer apply(Item t) {
				return t.getItemId();
			}
		});
		
		System.out.println("=======");

		
		Comparator<Item> comparator = comparing(i -> i.getStoreId());
		Arrays.sort(items, comparator.thenComparing(i -> i.getItemId(), reverseOrder()));
		ArrayUtils.printf(items);
		
		// Comparator.reverseOrder();
		// compare(o1, o2) >> compare(o2, o1)
		// swap o1, o2 
	}
	
	
	
	private static Item[] getItems() {
		return new Item[] {
				new Item(1, 28, "A", 278),
				new Item(1, 27, "C", 32),
				new Item(3, 25, "t", 48),
				new Item(4, 14, "e", 24),
				new Item(5, 22, "d", 223),
				new Item(6, 10, "s", 41),		
		};
	}
}
