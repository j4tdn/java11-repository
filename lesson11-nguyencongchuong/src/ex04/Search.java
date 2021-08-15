package ex04;

public class Search {
	public static void main(String[] args) {
		Dictionary dictionary = new Dictionary();
		dictionary.add(new Word("bacon", "The flesh of the back and sides of a pig, salted and dried, used as food",
								WordType.NOUN,
								"Books were what - across the arc of his career - brought home the bacon."));
		
		dictionary.add(new Word("carry", "to hold something or someone with your hands, arms, or on your back and transport it, him, or her from one place to another",
				WordType.VERD,
				"..."));
		
		dictionary.add(new Word("basic", "simple and not complicated, so able to provide the base or starting point from which something can develop",
				WordType.ADJECTIVE,
				"..."));
		System.out.println(dictionary.get("bacon"));
		System.out.println(dictionary.get("basic"));
	}
}
