package ex04;

import java.util.Map;
import java.util.TreeMap;

public class AppEx04 {
	public static void main(String[] args) {
		Map<String, Dictionary> dictionary = new TreeMap<>();
		
		dictionary.put("I", new Dictionary("I", "tôi", "danh từ", "aaaaaa"));
		dictionary.put("Love", new Dictionary("Love", "yêu", "động từ", "bbbbbbbbb"));
		dictionary.put("you", new Dictionary("you", "bạn", "danh từ", "cccccc"));
		
		DictionaryUtils.add(dictionary, new Dictionary("connect", "kết nối", "động từ", "dddddd"));
		
		System.out.println(dictionary.size());
		
		DictionaryUtils.search(dictionary, "Love");
		
	}
}
