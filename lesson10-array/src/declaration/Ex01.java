package declaration;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import bean.Item;

public class Ex01 {
	 
	
	public static void main(String[] args) {
		//digits ={0,0,0,0}
		int[] digits = new int[4];
		System.out.println("length: " + digits.length);
		System.out.println("digit i: " + digits[2]);
		
		int[] numbers = {4,7,9};
		System.out.println("length number: " + numbers.length );
		System.out.println("number i :" + numbers[0]);
		
		System.out.println("numbers's class: " + numbers.getClass() );
		
		//for index loop end to start
		for(int i = numbers.length-1; i>=0; i--) {
			System.out.println("index " + i + ": " + numbers[i]);
		}
		//for each
		int nb = 0;
		for(int numb: numbers) {
			System.out.println("numb "+ nb + ": " +numb);
			nb++;
		}
		
		
		String[] sequences = new String[10];
		System.out.println("sequences i: " + sequences[0]);
		
		System.out.println("sequences's class: " + sequences.getClass() );
		
		System.out.println("==============================");
		
		String[] names = {"a","b","c"};
		System.out.println("name :" + names[1]);
		//items = {null,null}
		
		
		
		Item[] items = new Item[2];
		try {items[0].setItemId(10); //NPE
			
		} catch (NullPointerException e) {
			System.out.println("items[0] = " + items[0]);
		}
		
		System.out.println("====================================");
		//format 1 so Decimal format, Number format
		
		Item[] preItems = {new Item(10, "A", 200), new Item(12, "B", 300)};
		System.out.println("preItems[1] => " + preItems[1]);
		System.out.println("items[0] name: " + preItems[0].getName());
		System.out.println("items[1] name: " + new DecimalFormat("#,###.00").format(preItems[1].getPrice()));
		//NumberFormat.getInstance().format(preItems[1].getPrice());
		
	}
	
	
}
