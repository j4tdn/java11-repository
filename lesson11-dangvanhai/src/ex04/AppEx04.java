package ex04;


import utils.CollectionUtils;

public class AppEx04 {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		
		// Add a word into my dictionary
		Word newWord = new Word("assessment", TypeOfWord.NOUN, 
				" an opinion or a judgement about somebody/something that has been thought about very carefully", 
				"a detailed assessment of the risks involved");
		dictionary.add(newWord);
		
		// Add a word which has multiple types of word
		dictionary.add(new Word("early", TypeOfWord.ADJECTIVE, 
				"near the beginning of a period of time, an event etc.", 
				"in the early years of the twentieth century"));
		dictionary.add(new Word("early", TypeOfWord.ADVERD, 
				"near the beginning of a period of time, an event, a piece of work, etc.",
				"as early as something He started writing music as early as 1989."));
		
		// Search word by key: "assessment"
		System.out.println("=========== Search word - assessment ===========" );
		CollectionUtils.printf(dictionary.get("assessment"));
		
		// Search word by key: "early"
		System.out.println("=========== Search word - early ===========" );
		CollectionUtils.printf(dictionary.get("early"));
		
		// Get list key of Dictionary
		System.out.println("=========== Dictionary ===========");
		CollectionUtils.printf(dictionary.getList());
	}
}
