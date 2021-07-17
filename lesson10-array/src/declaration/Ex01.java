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
				System.out.println("numbers length: " + numbers.length);
				System.out.println("numbers i: " + numbers[2]);

				System.out.println("number's class: " + numbers.getClass());

				// for index
				for (int i = 0; i < numbers.length; i++) {
					System.out.println("index " + i + ": " + numbers[i]);
				}

				// for-each
				for (int numb : numbers) {
					System.out.println("numb: " + numb);
				}

				// items = {null, null}
				Item[] items = new Item[2];
				System.out.println("items[0]" + items[0]);

				// items[0].setId(10) // Null Pointer Exception

				Item[] preItems = { new Item(10, "A", 200), new Item(12, "B", 100), new Item(14, "C", 300),
						new Item(16, "D", 600) };

				System.out.println("preItems[1] => " + preItems[1]);
				System.out.println("items[0] name: " + preItems[0].getName());
				System.out.println("items[0] price: " + new DecimalFormat("#,###.##").format(preItems[0].getPrice()));
				System.out.println("items[1] price: " + NumberFormat.getInstance().format(preItems[0].getPrice()));

	}
}
