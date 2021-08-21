package ex04;

public class App {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary();
		dic.setDictionary(Utils.getData());
		Utils.print(dic);
		
		// Add word
		Word word = new Word("Home", "Nhà", WordType.NOUN, "None");
		if(dic.addWord(word)) {
			System.out.println("Add successfully!");
			Utils.print(dic);
		} else {
			System.out.println("Add failure!");
		}
		
		// Search word
		if(dic.search("Home") != null) {
			System.out.println(dic.search("Home"));
		} else {
			System.out.println("Can't find data!");
		}
	}
}
