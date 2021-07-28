package sorting;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;

import utils.ArrayUtils;

public class Ex08 {
	public static void main(String[] args) {
		// Sorting with String special case
		// CASE SENSITIVE CS || CASE INSENSITIVE CI
		// SIGN || UNSIGN
		// A a B b Ã� Ã 

		// CASE INSENSITIVE
		// A Ã� a Ã  B b
		// a Ã  A Ã� b B

		// A: 65
		// a: 92
		// CASE SENSITIVE
		// A Ã� B a Ã  b

		// SIGN
		// A B Ã� a b Ã 
		String[] text = { "b", "B", "A", "a", "Ã�", "áº¥", "Ãª", "á»�", "c", "C" };

		// unicode: CASE SENSITIVE >> SIGN
		Arrays.sort(text);
		ArrayUtils.printf(text);

		// unicode: CASE INSENSITIVE >> SIGN
		Arrays.sort(text, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		}); 
		ArrayUtils.printf(text);
		System.out.println("===================");

		collatorSort(text, Collator.PRIMARY);
		collatorSort(text, Collator.SECONDARY);
		collatorSort(text, Collator.TERTIARY);
		collatorSort(text, Collator.IDENTICAL);
	}

	private static void collatorSort(String[] text, int strength) {
		Collator collator = Collator.getInstance();
		collator.setStrength(strength); // set rule
		Arrays.sort(text, collator);
		ArrayUtils.printf(text);
	}
}