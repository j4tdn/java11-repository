package sorting;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;

import bean.Item;
import utils.ArrayUtils;

public class Ex07 {
public static void main(String[] args) {
	Item[] items = getItems();
	Arrays.sort(items, comparing(i-> i.getName()));
	ArrayUtils.printf(items);
	System.out.println("=======");
	Comparator<Item> comparator = comparing(i-> i.getStoreId());
	Arrays.sort(items, comparator.thenComparing(i -> i.getItemId(), reverseOrder()));
	ArrayUtils.printf(items);
}

private static Item[] getItems() {
	return new Item[] {
			new Item(1 ,12 ,"A",278.2d),
			new Item(4 ,132,"B",228.5d),
			new Item(2 ,122,"C",212),
			new Item(12,212,"D",120),
			new Item(11,123,"E",412)
};
}
}

