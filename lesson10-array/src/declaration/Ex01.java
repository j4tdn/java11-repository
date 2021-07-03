package declaration;

import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	public static void main(String[] args) {
		int[] digits = new int[4];
		System.out.println("length: " + digits.length);
		System.out.println("digits i: " + digits[2]);
		
		int[] numbers = {4,7,9};
		System.out.println("length: " + numbers.length);
		System.out.println("numbers i: " + numbers[2]);
		
		System.out.println("numbers's class: " + numbers.getClass());
		
		// for-index
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("index " + i +  ": " + numbers[i]);
		}
		
		//loop end to start
		for(int i = numbers.length - 1; i >= 0; i--) {
			System.out.println("index " + i + ": " + numbers[i]);
		}
		
		//for-each
		int nb = 0;
		for(int numb: numbers) {
			System.out.println("numb " + nb + ": " + numb);
			 nb++;
		}
		
		System.out.println("=============================");
		
		//String
		
		String[] sequences = new String[10];
		System.out.println("sequences i: " + sequences[0]);
		
		System.out.println("sequences's class" + sequences.getClass());
		
		String[] names = {"a", "b", "c"};
		System.out.println("name[1]: " + names[1]);
		
		System.out.println("=============================");
		
		Item[] items = new Item[2];
		
		System.out.println("items's class" + items.getClass());
		
//		items[0].setId(10);
		System.out.println("item[0] = " + items[0]);
		
		Item[] preItems = { new Item(10, "A", 200), new Item(12, "B", 300)};
		System.out.println("preItems[1] => " + preItems[1]);
		System.out.println("items[0] name: " + preItems[0].getName());
		System.out.println("items[1] price: " + NumberFormat.getInstance().format(preItems[1].getPrice()));
	
	}

}
