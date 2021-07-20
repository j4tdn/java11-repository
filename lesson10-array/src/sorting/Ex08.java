package sorting;

import java.text.Collator;
import java.util.Arrays;

import utils.ArrayUtils;

public class Ex08 {
	public static void main(String[] args) {
		// Sorting with String special case
		// CASE SENTIVE || CASE INSENSITIVE
		// SIGN || UNSIGN
		
		String[] text= {"B", "b", "A", "a", "Á", "á", "c", "C"};
		Arrays.sort(text);
		ArrayUtils.printf(text);	
		
		Arrays.sort(text, (s1,s2) -> s1.compareToIgnoreCase(s2));
		ArrayUtils.printf(text);
		System.out.println("==================================");
		collatorSort(text, Collator.PRIMARY);
		collatorSort(text, Collator.SECONDARY);
		collatorSort(text, Collator.TERTIARY);
		collatorSort(text, Collator.IDENTICAL);
		
	}
	
	private static void collatorSort(String[] text ,int strength) {
		Collator collator = Collator.getInstance();
		collator.setStrength(strength);
		Arrays.sort(text, collator);
		ArrayUtils.printf(text);
	}
}
