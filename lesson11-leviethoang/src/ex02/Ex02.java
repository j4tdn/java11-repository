package ex02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import utils.CollectionUtils;


public class Ex02 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		List<CD> items = getCD();
		int key;
		do {
		System.out.println("=======================================");
		System.out.println("Enter the number 1 to add to the list ");
		System.out.println("Enter the number 2 to get amount in the list  ");
		System.out.println("Enter the number 3 to calculate the total price of the CDs ");
		System.out.println("Enter number 4 to sort the list descending by price ");
		System.out.println("Enter number 5 to sort the list ascending by id ");
		
		System.out.print("Enter the case you want to select : ");
		key = Integer.parseInt(ip.nextLine());
		}while(key < 1 || key > 5 );
		
		switch (key) {
		case 1:
			CD  cd = new CD(5, "E", "Bray", 6, 35000d);
			if(!(items.contains(cd))) {
				items.add(cd);
				System.out.println("Successful !!!");
			}else {
				System.out.println("The CD already exists in the list !!!");
			}
			break;
		case 2 : 
			System.out.println( "amount in the list : " + items.size());
			break;
		case 3 :	
			double sum = 0;
			for(CD c : items) {
				sum += c.getPrice();
			}
			System.out.println("the total price of the CDs : " + sum);
			break;
		case 4 : 
			items.sort(Comparator.comparing(CD::getPrice).reversed());
			break;
		case 5 : 
			items.sort(Comparator.comparing(CD::getId));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + key);
		}
		
		System.out.println("==========Print========================");
		CollectionUtils.printf(items);
	}		
	
	private  static List<CD> getCD(){	
		return 	 Arrays.asList(
			new CD(1, "A", "Bich Phuong", 5, 50000d),	
			new CD(2, "B", "Son Tung", 4, 15000d),
			new CD(3, "C", "Erik", 3, 25000d),	
			new CD(4, "D", "Den vau ", 8, 65000d),
			new CD(5, "E", "Bray", 6, 35000d)	
				);
	}
	
	
}
