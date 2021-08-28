package ex04;

import java.util.Map;
import java.util.Scanner;

public class Ex04 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		Map<String, Vocabulary> dicMap = Dictionary.getDictionary();
	System.out.println(Dictionary.addW(dicMap, new Vocabulary("love", "tình yêu", "noun", "danh từ")));
	System.out.println(Dictionary.addW(dicMap, new Vocabulary("map", "bản đồ", "noun", "danh từ")));
		
		System.out.print("Find the word in dictionary : ");
		String word = ip.nextLine();
		
		System.out.println(Dictionary.findWorld(dicMap, word));
	}
	
}
