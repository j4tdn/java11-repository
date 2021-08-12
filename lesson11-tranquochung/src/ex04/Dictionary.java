package ex04;

import java.util.HashSet;
import java.util.Set;

public class Dictionary {
	public static void main(String[] args) {
		Set<WordEnglish> words = getWord();
		add(words, new WordEnglish("bird", "noun", null));
		printf(words);

		System.out.println("<<=== Word Find ===>>");
		WordEnglish word = search(words, "chicken");
		System.out.println(word);
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

	private static Set<WordEnglish> getWord() {
		Set<WordEnglish> words = new HashSet<>();
		words.add(new WordEnglish("buffalo", "noun", null));
		words.add(new WordEnglish("chicken", "noun", null));
		words.add(new WordEnglish("go", "verd", null));
		words.add(new WordEnglish("swim", "verd", null));
		words.add(new WordEnglish("beautiful", "adj", null));
		return words;
	}

	private static <E> void printf(Set<E> elements) {
		for (E e : elements) {
			System.out.println(e);
		}
	}
}
