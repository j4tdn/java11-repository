package declaration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		// digits = {0,0,0,0}
		int[] digits = new int[4];
		System.out.println("length: " + digits.length);
		System.out.println("digits i: " + digits[2]);

		int[] numbers = { 4, 7, 9 };
		System.out.println("length: " + numbers.length);
		System.out.println("digits i: " + numbers[2]);

		// for-index
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("index " + i + ": " + numbers[i]);
		}
		
		System.out.println("number's class: " + numbers.getClass());
		
		// for-each
		int nb = 0;
		for (int numb : numbers) {
			System.out.println("numb " + nb++ + ": " + numb);
		}
		
		// String
		String[] sequences = new String[10];
		System.out.println("sequences i: " + sequences[0]);
		
		System.out.println("sequences's class: " + sequences.getClass());
		
		// items = {null, null};
		Item[] items = new Item[2];
		// items[0].setId(10);
		System.out.println("item[0] = " + items[0]);
		System.out.println("items class: " + items.getClass());
		
		Item[] preItems = { new Item(10, "A", 200), new Item(11, "B", 300), new Item(), };
		System.out.println("preItems[1] =>" + preItems[2]);
		System.out.println("items[0] name: " + preItems[0].getName());
		System.out.println("items[0] price: " + new DecimalFormat("#,###").format(preItems[0].getPrice()));
		System.out.println("items[0] price: " + NumberFormat.getInstance().format(preItems[0].getPrice()));

	}

}
