package ex04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Dictionary {
	private Map<String, List<Word>> words;

	public Dictionary() {
		words = new HashMap<>();
	}

	/**
	 * If the dictionary previously contained the word which has the same name and
	 * type of word, the old word is replaced by the new word
	 * 
	 * @param word
	 */
	public void add(Word word) {
		Objects.requireNonNull(word);
		var myWords = words.get(word.getName());
		if (myWords == null) {
			myWords = new ArrayList<>();
			myWords.add(word);
		} else if (myWords.contains(word)) {
			int index = myWords.indexOf(word);
			myWords.set(index, word);
		} else {
			myWords.add(word);
		}
		words.put(word.getName(), myWords);
	}

	/**
	 * 
	 * @param key
	 * @return list of all definitions of the word
	 */
	public List<Word> get(String key) {
		return words.get(key);
	}

	public List<String> getList() {
		return new ArrayList<String>(words.keySet());
	}

	public List<String> getList(Comparator<String> comparator) {
		List<String> result = new ArrayList<String>(words.keySet());
		result.sort(comparator);
		return result;
	}
}
