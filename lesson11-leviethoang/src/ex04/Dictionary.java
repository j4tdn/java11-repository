package ex04;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
	private Dictionary() {
	}
	
	public static boolean addW(Map<String, Vocabulary> dictionary, Vocabulary voc) {
		if (!(dictionary.containsKey(voc.getWord()))) {
			dictionary.put(voc.getWord(), voc);
			return true;
		}
		return false;
	}
	
	public static Vocabulary findWorld(Map<String, Vocabulary> dictionary, String word) {
		return dictionary.get(word);
	}
	
	public static Map<String, Vocabulary> getDictionary(){
		Map<String, Vocabulary> dictionary = new HashMap<>();
		dictionary.put("map", new Vocabulary("map", "bản đồ", "noun", "danh từ"));
		dictionary.put("goverment", new Vocabulary("goverment", "chính phủ", "noun", "danh từ"));
		dictionary.put("play", new Vocabulary("play", "chơi", "verb", "động từ"));
		dictionary.put("beautiful", new Vocabulary("beautiful", "adjective", "", "tính từ"));
		
		return dictionary;
	}
}
