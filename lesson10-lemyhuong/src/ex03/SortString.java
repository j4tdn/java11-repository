package ex03;

import utils.ArrayUtils;
import utils.Swap;

public class SortString {
	public static void main(String[] args) {
		String [] strings = {"-2", "-6", "10", null, "4", "8", null, "Special", "xx", "a", "c", "b"};
	
		
		// ascending: Special, -6, -2, 4, 8, 10, a, b, c, xx, null, null 
		for (int i = 0; i < strings.length; i++) {
			for (int j = 0; j < strings.length - i - 1; j ++) {
//				if (strings[j].com) {
//					continue;
//				}
				
				if (strings[j] == null && strings[j+1] != null) {
					Swap.swap(strings, j, j + 1);
					continue;
				}
				
				if (strings[j+1] == null) {
					continue;
				}
				
				if (strings[j].compareTo(strings[j + 1]) > 0) {
					Swap.swap(strings, j, j + 1);
				}
			}
		}
		
		ArrayUtils.printf(strings);
	}

}
