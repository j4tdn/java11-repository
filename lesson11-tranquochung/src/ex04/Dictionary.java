package ex04;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {
	public static void main(String[] args) {
		Set<WordEnglish> words = new HashSet<>();
	}

	private static boolean add(Set<WordEnglish> words, WordEnglish word) {
		return words.add(word);
	}

	private static WordEnglish search(Set<WordEnglish> words, String word) {
		for (WordEnglish w : words) {
			if (w.getWord().equals(word)) {
				return w;
			}
		}
		return null;
	}

}
