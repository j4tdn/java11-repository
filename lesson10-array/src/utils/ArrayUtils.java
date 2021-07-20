package utils;

import java.util.Arrays;

import bean.Item;
import bean.SortOrder;
import manipulation.*;

public class ArrayUtils {
    private ArrayUtils() {
		
	}
    public static void sort(int[] digits, SortOrder order) {
    	Arrays.sort(digits);
    	if(order == SortOrder.DESC) {
    		reverse(digits);
   
    	}
    }
	public static void printf(Item[] items) {
		for (Item item: items) {
			System.out.println(item);
		}
	}
	public static void printf(String[] elements) {
		for (String element: elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void printf(int[] elements) {
		for (int element: elements) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
