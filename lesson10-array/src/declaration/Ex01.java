package declaration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = new int[4];
		System.out.println("length" + digits.length);
		System.out.println("digits i : " + digits[3]);

		int[] numbers = { 4, 7, 9 };
		System.out.println(numbers.length);
		System.out.println("numbers i : " + numbers[2]);
		System.out.println("numbers class : " + numbers.getClass().getSimpleName());
		
		// for-index
		for(int i = 0; i < numbers.length ; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		
		// for -each
		for(int numb : numbers) {
			System.out.print(numb + " ");
		}
		System.out.println();
		
		
// 		items = {null, null}
		Item[] items = new Item[2];
//		items[2].setId(3); // null pointer exception

		Item[] preItems = { new Item(10, "A", 200), new Item(12, "B", 300) };
		System.out.println("preItems[1] => : " + preItems[1]);
		System.out.println("preItem[0] name : " + preItems[0].getName());
		System.out.println("preItem[1] price : " + new DecimalFormat("#,###.##").format(preItems[1].getPrice()));
		System.out.println("preItem[1] price : " + NumberFormat.getInstance().format(preItems[1].getPrice()));

		String[] sequences = new String[10];
		System.out.println("sequences 1 : " + sequences[0]);

		System.out.println("sequences class : " + sequences.getClass());
		
		String[] names = { "a", "b", "c" };
		System.out.println("names[1] : " + names[1]);
	}
}
