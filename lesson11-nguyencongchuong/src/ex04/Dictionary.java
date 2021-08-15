package ex04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
	
	private Map<String, List<Word>> mapWord;
	
	public Dictionary() {
		 mapWord = new HashMap<>();
	}
	
	public void add(Word word) {
		List<Word> listWord = new ArrayList<>();
		listWord.add(word);
		mapWord.put(word.getVocabulary(), listWord);
	}

	public List<Word> get(String key) {
		return mapWord.get(key);
	}


	
}
