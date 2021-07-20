package sorting;

import java.text.Collator;
import java.util.Arrays;

import untils.ArrayUtils;

public class Ex08 {
	public static void main(String[] args) {

		// Sorting with String special case
		// CASE SENSITIVE CS || CASE INSENSITIVE CI
		// SIGN || UNSIGN
		// A a B b � �

		// CASE INSENSITIVE
		// A � a � B b
		// a � A � b B

		// A: 65
		// a: 92
		// CASE SENSITIVE
		// A � B a � b

		// SIGN
		// A B � a b �

		String[] text = { "B", "b", "A", "a", "�", "�", "c", "C" };
		// unicode: CASE SENSITIVE >> SIGN
		Arrays.sort(text);
		ArrayUtils.printf(text);

		// unicode: CASE INSENSITIVE >> SIGN
		Arrays.sort(text, (o1, o2) -> o1.compareToIgnoreCase(o2));
		ArrayUtils.printf(text);
		collatorSort(text, Collator.PRIMARY);
		collatorSort(text, Collator.SECONDARY);
		collatorSort(text, Collator.TERTIARY);
		collatorSort(text, Collator.IDENTICAL);
	}

	private static void collatorSort(String[] text, int strength) {
		Collator collator = Collator.getInstance();
		collator.setStrength(strength);
		Arrays.sort(text, collator);
		ArrayUtils.printf(text);
	}
}
