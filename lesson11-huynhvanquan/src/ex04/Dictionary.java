package ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Dictionary {
	Map<String, Word> wordList;
	Dictionary() {
		wordList = new HashMap<String, Word>();
	}
	public void setDictionary(HashMap<String, Word> wordList) {
		this.wordList = wordList;
	}
	public HashMap<String, Word> getDictionary() {
		return (HashMap<String, Word>) this.wordList;
	}
	public boolean addWord(Word newWord) {
		if (wordList.containsKey(newWord.getIdentityName()) || newWord.getIdentityName().equals("")) {
			return false;
		}
		wordList.put(newWord.identityName, newWord);
		return true;
	}
	
	public Word search(String key) {
		if (wordList.containsKey(key)) {
			return wordList.get(key);
		}
		return null;
	}
}
