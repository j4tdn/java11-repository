package declaration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	
	public static void main(String[] args) {
		// digits = {0,0,0,0} c1
		int[] digits = new int[4];
		
		System.out.println("length: " + digits.length);
		System.out.println("digits i: " + digits[3]);
		
		//c2
		int[] numbers = {4,7,9};
		System.out.println("length: " + numbers.length);
		System.out.println("numbers i: " + numbers[2]);
		
		
		// for-index
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("index " +i + ": " + numbers[i]);
		}
		//for each
		int nb = 0;
		for(int numb: numbers) {
			System.out.println("numb "+ nb++ + ": "+numb);
		}
		
		System.out.println("===========================");
		String[] sequences = new String[10];
		System.out.println("sequences[0]: "+sequences[0]);
		System.out.println("sequence's class: " + sequences.getClass());
		
		String[] names = {"a","b","c"};
		System.out.println("names[1]: "+names[1]);
		
		System.out.println("===========================");
		//Item
		Item[] items =new Item[2];
		
		System.out.println("items[0]: "+items[0]);
		
		Item[] preItems = { 
				new Item(10, "A",200),  new Item(10, "B",300)
		};
		System.out.println("preItems[1] => "+preItems[1]);
		System.out.println("items[0] name => "+preItems[0].getName());
		System.out.println("items[1] price => "+new DecimalFormat("#,###").format(preItems[1].getPrice()));
		System.out.println("items[1] price => "+ NumberFormat.getInstance().format(preItems[1].getPrice()));
	}

}
