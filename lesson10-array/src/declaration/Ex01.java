package declaration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {

		int[] digits = new int[4];
		System.out.println("digits lenghth: " + digits.length);
		System.out.println("digits i: " + digits[3]);

		int[] number = { 4, 7, 9 };
		System.out.println("lenghth: " + number.length);
		System.out.println("digits i: " + number[2]);
		System.out.println("numberclass: "+ number.getClass());
		
		// for index
		for (int i = 0; i < number.length; i++) {
			System.out.println("index " + i + ":" + number[i]);
		}
		// for each
		int nb = 0;
		for (int numb : number) {
			System.out.println("numb: " + nb + ": " + numb);
			nb++;
		}

		System.out.println("====================");
		// String
		String[] sequences = new String[10];
		System.out.println(sequences[0]);
		
		System.out.println("sequenses's class: "+ sequences.getClass());
		
		String[] names = { "a", "b", "c" };
		System.out.println(names[1]);

		System.out.println("====================");

		// items = null null
		Item[] items = new Item[2];
		// items[0].setId(10);
		System.out.println("item[0] = " + items[0]);

		Item[] preItems = { new Item(10, "A", 200), new Item(12, "B", 300) };
		System.out.println("preItems[1]=> " + preItems[1]);
		System.out.println("item[0] name: " + preItems[0].getName());
		System.out.println("item[1] price: " + new DecimalFormat("#,###.00").format(preItems[1].getPrice()));
		System.out.println("item[1] price: " + NumberFormat.getInstance().format(preItems[1].getPrice()));

	}
}
