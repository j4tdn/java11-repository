package example04;

import java.util.Map;

public class Ex04 {
	public static void main(String[] args) {
		Map<String, Vocabulary> dictionary = Dictionary.getDic();
		Vocabulary glass = new Vocabulary("glass", "cai kinh", "noun", "ai bị cận thì đeo");
		Vocabulary sleep = new Vocabulary("sleep", "ngu", "verb", "ngủ quá giờ trưa");
		
		Dictionary.addWord(dictionary, sleep);
		Dictionary.addWord(dictionary, glass);
		
		Vocabulary f1 = Dictionary.search(dictionary, "lovely");
		Vocabulary f2 = Dictionary.search(dictionary, "sleep");
		
		System.out.println(f1);
		System.out.println(f2);
		
	}
}
