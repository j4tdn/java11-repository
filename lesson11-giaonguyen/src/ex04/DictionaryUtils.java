package ex04;

import java.util.Map;

public class DictionaryUtils {
	private DictionaryUtils() {
		
	}
	
	public static void add(Map<String, Dictionary> map, Dictionary dic) {
		 map.put(dic.getWord(), dic);	 
	}
	
	public static void search(Map<String, Dictionary> map, String str) {
		System.out.println(map.get(str));
	}
	
}
