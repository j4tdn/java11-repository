package ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Dictionary {
	public static void main(String[] args) {
		Map<Vocabulary, Description> dictionary = getDic();

		System.out.println("===== Add New Dictionary =====");
		Map<Vocabulary, Description> add = getDic();
		// duplicate key and update value
		add.put(new Vocabulary("book"), new Description("book111", "sach111", "noun111", "old book111"));
		// duplicate key
		add.put(new Vocabulary("bOOk"), new Description("book", "sach", "noun", "old book"));
		// duplicate key and update value
		add.put(new Vocabulary("bOoK"), new Description("book111", "sach111", "noun111", "old book111"));
		// new
		add.put(new Vocabulary("clothes"), new Description("clothes", "quan ao", "noun", "put on one's clothes"));
		printf(add);

		System.out.println("===== Search =====");
		search("book", dictionary);
		search("HoTEl", dictionary);
	}

	public static Map<Vocabulary, Description> getDic() {
		Map<Vocabulary, Description> dictionary = new HashMap<>();

		dictionary.put(new Vocabulary("look"), new Description("look", "nhin", "verb", "we looked but saw nothing"));
		dictionary.put(new Vocabulary("book"), new Description("book", "sach", "noun", "old book"));
		dictionary.put(new Vocabulary("desk"), new Description("desk", "cai ban", "noun", "an office desk"));
		dictionary.put(new Vocabulary("hotel"), new Description("hotel", "khach san", "noun", "Chain hotels	"));
		dictionary.put(new Vocabulary("today"),	new Description("today", "hom nay", "adverbs", "what are you doing today?"));

		return dictionary;
	}

	public static void printf(Map<Vocabulary, Description> map) {
		Set<Entry<Vocabulary, Description>> entrys = map.entrySet();
		for (Entry<Vocabulary, Description> entry : entrys) {
			System.out.println("key : " + entry.getKey());
			System.out.println("value : " + entry.getValue());
			System.out.println();
		}
	}

	public static void search(String voc, Map<Vocabulary, Description> map) {
		for (Entry<Vocabulary, Description> entry : map.entrySet()) {
			if (voc.equalsIgnoreCase(entry.getKey().getVoc())) {
				System.out.println("key: " + entry.getKey());
				System.out.println("value: " + entry.getValue());
				System.out.println();
			}
		}
	}
}
