package declaration;

import java.text.DecimalFormat;

import bean.Item;

public class Ex01 {
	 public static void main(String[] args) { 
		 int[] digits = new int[4];
		 
		 System.out.println("length: " + digits.length);
		 System.out.println("digits: " + digits[2]);
		 
		 int[] numbers = {4,7,9};
		 System.out.println("numbers length: " + numbers.length);
		 System.out.println("numbers: " + numbers[2]);
		 
		 System.out.println("numbers's class: " + numbers.getClass());
		 
		 Item[] items = new Item[2];
		 
		 Item[] preItems = {new Item(10, "A", 10), new Item(20, "B", 100)};
		 System.out.println(preItems[1]);
		 System.out.println(preItems[0].getName());
		 System.out.println(new DecimalFormat("#,###").format(preItems[1].getPrice()));
		 
		 for (int i = 0; i < numbers.length; ++i) {
			 System.out.println("index " + i + ":" + numbers[i]);
		 }
		 
		 for (int numb: numbers) {
			 System.out.println(numb);
		 }
	}
}
