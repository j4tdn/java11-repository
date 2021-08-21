package ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Utils {
	private Utils() {}
	public static HashMap<String, Word> getData() {
		Map<String, Word> wordList = new HashMap<String, Word>();
		wordList.put("Car", new Word("Car", "Xe", WordType.NOUN, "None"));
		wordList.put("Cat", new Word("Cat", "Mèo", WordType.NOUN, "None"));
		wordList.put("Dog", new Word("Dog", "Chó", WordType.NOUN, "None"));
		wordList.put("Tiger", new Word("Tiger", "Cọp", WordType.NOUN, "None"));
		return (HashMap<String, Word>) wordList;
	}
	public static void print(Dictionary dic) {
		Set<Entry<String, Word>> set = dic.getDictionary().entrySet();
		for(Entry<String, Word> item : set) {
			System.out.println(item.getKey() + " - " + item.getValue());
		}
	}
}
