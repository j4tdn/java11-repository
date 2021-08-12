package collection.set;

import java.util.HashSet;
import java.util.Set;

import bean.Item;

public class Ex02 {
	public static void main(String[] args) {
		Set<Item > items = new HashSet<>();
		items.add(new Item(101, 1, "A", 120));
		items.add(new Item(102, 2, "B", 150));
		items.add(new Item(103, 3, "C", 200));
		
		items.add(new Item(101, 1, "C", 120));
	
	System.out.println("size: " + items.size());
	}
}
