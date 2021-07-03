package declaration;

import java.text.DecimalFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		// digits = {0.0.0.0}
		int[] digits = new int[4];
		System.out.println("lenght: " + digits.length);
		System.out.println("digit i: " + digits[3]);
		
		int [] numbers = {1,2,3};
		System.out.println("lenght: " + numbers.length);
		System.out.println("digit i: " + numbers[2]);
		
		//for-index
		for (int i = 0; i < numbers.length; i++) {
			System.out.println("index " + i + ": " + numbers[i]);
		}
		
		//for-each
		for (int numb : numbers) {
			System.out.println("numb: " + numb);
		}
		
		String[] sequences = new String[10];
		System.out.println("sequence i: " + sequences[0]);
		
		String[] names = {"a", "b"};
		System.out.println("name[1]: " + names[1]);
		System.out.println("sequence's class: " + sequences.getClass());
		
		//items = {null, null}
		Item[] items = new Item[2];
		// items[0].setId(10);
		System.out.println("items[0] = " + items[0]);
		
		Item[] preItems = {new Item(10, "a", 200), new Item(12, "b", 300)};
		System.out.println("preItems[1] => " + preItems[1]);
		System.out.println("items[1] name: " + preItems[1].getName());
		System.out.println("items[1] price: " + new DecimalFormat("#.##").format(preItems[1].getPrice()));
		
	}
}
