package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;


import bean.Item;

public class Ex07 {
	public static void main(String[] args) {
		Item[] items = getItems();
		
//		//cách 1: dùng lambda tự viết
//		Comparator<Item> comp = (c1,c2) -> c1.getItemId() - c2.getItemId();
//		Arrays.sort(items,comp);
		
		//cách 2: dùng hàm viết sẵn của java (comparator.comparing)
		Comparator<Item> comparator = comparing(i -> i.getStoreId()); 
		Arrays.sort(items, comparator.thenComparing(i -> i.getItemId(), reverseOrder()).reversed()); //getStoreID (xếp tăng dần) bằng nhau thì so sánh tiếp getItemID (reverse -> giảm dần)
																									// sau đó reverse toàn bộ mảng (xếp giảm dần)
//		//cách 3:
//		Arrays.sort(items,new Comparator<Item>() {
//			@Override
//			public int compare(Item o1, Item o2) {
//				return o1.getItemId() - o2.getItemId();
//			}
//		});
//		
//		Arrays.sort(items,new Comparator<Item>() {
//			@Override
//			public int compare(Item o1, Item o2) {
//				return Double.compare(o1.getPrice(), o2.getPrice());
//			}
//		});
		
		for (Item i: items) {
			System.out.println(i);
		}
	}
	
	private static Item[] getItems() {
		return new Item[] {
				new Item(1, 12, "a", 278.4d),
				new Item(2, 27, "B", 12),
				new Item(3, 12, "c", 278.5d),
				new Item(2, 29, "D", 259.2d),
				new Item(1, 18, "f", 278.6d),
				new Item(1, 10, "K", 159.1d),
				new Item(4, 12, "B", 47)
		};
	}
}
