package declaration;

import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = new int[4];
		
		System.out.println("length: "+ digits.length);
		System.out.println("digit i: " +digits[3]);
		
		int[] numbers =  {1, 5, 9, 8};
		//for-index
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("index "+ i + ": " + numbers[i]);
		}
		// loop end to start
		for(int i = numbers.length - 1; i >= 0; i-- ) {
			System.out.println("index "+ i + ": " + numbers[i]);
		}
		//for each
		for(int numb: numbers) {
			System.out.println("numb: " + numb);
		}
		System.out.println("length: "+ numbers.length);
		System.out.println("number i: " +numbers[3]);
		
		String [] sequences = new String[10];
		System.out.println("sequence: "+ sequences[1]);
		System.out.println("squence's class " + sequences.getClass());
		
		String [] name = {"a", "b", "c"};
		System.out.println("name: "+ name[1]);
		
		Item[] items = new Item[2];
		System.out.println("items's class " + items.getClass());

	//	items[0].setId(10);
	//	System.out.println("items[0] = " + items[0]);
		
		Item[] preItems = {
				new Item(10, "A", 200), new Item(12, "B", 200),new Item(13, "C", 225)
		};
		System.out.println("preItems[1]" + preItems[1]);
		System.out.println("item[0] name: " + preItems[0].getName());
		System.out.println("item[0] price: " + NumberFormat.getInstance().format(preItems[0].getPrice()));
	}
}
