package ex04;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class App {
	public static void main(String[] args) {
		Map<Vocabulary, Description> dictionary = getDic();

		System.out.println("===== Add New Dictionary =====");
		Map<Vocabulary, Description> add = getDic();
		add.put(new Vocabulary("book"), new Description("book", "sach", "noun"));
		add.put(new Vocabulary("clothes"), new Description("clothes", "quan ao", "noun"));
		printf(add);

		System.out.println("===== Search =====");
		search("book", dictionary);
		search("Hello", dictionary);
	}

	public static Map<Vocabulary, Description> getDic() {
		Map<Vocabulary, Description> dictionary = new HashMap<>();

		dictionary.put(new Vocabulary("book"), new Description("book", "sach", "noun"));
		dictionary.put(new Vocabulary("hello"), new Description("hello", "xin chao", "verb"));
		dictionary.put(new Vocabulary("house"), new Description("house", "ngoi nha", "noun"));
		dictionary.put(new Vocabulary("see"), new Description("see", "nhin", "verb"));

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