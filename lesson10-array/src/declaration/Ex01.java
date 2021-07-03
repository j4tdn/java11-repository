package declaration;

import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = new int[4];
		System.out.println(digits.length);
		System.out.println(digits[2]);
		
		
		Item[] items = new Item[2];
		System.out.println(items[0]);
		
		
		Item[] preItems = {new Item(10, "A", 200), new Item(10, "B", 300)};
		System.out.println(preItems[0].getName());
		System.out.println(NumberFormat.getInstance().format(preItems[1].getPrice()));
	}

}
