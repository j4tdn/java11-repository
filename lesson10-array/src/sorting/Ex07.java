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
		
		//lambda expression
		//Function<T, R> >> t -> t.X();
		// t: instance of T
		// X : T's method return R
		
		Item itemX = new Item(111,5, "AAA", 333);
		Function<Item, String> f1 = item -> item.getName();
		System.out.println("f1: " + f1.apply(itemX));
		
		// Truyeenf vao kieu Item tra ve String 
		// method reference
		Function<Item,Integer> f2 = Item::getItemId;
		System.out.println("f2: " + f2.apply(itemX));
		
		ArrayUtils.printf(items);
		
		
		System.out.println("=======");
		
		Function<Item, Integer> f3 = Item::getStoreId;
		System.out.println("f3: " + f3.apply(itemX));
		
		Comparator<Item > comp1 = (Item o1, Item o2) ->{
			return o1.getItemId() - o2.getItemId();
		};
		
		Comparator<Item> comp2 = (o1, o2) -> o1.getItemId() - o2.getItemId();
		
		Comparator<Item> comp3 = comparing(new Function<Item, Integer>() {

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
