package example04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Dictionary {

	private Dictionary() {
	}

	public static Map<String, Vocabulary> getDic() {
		Map<String, Vocabulary> dic = new HashMap<>();

		dic.put("developer", new Vocabulary("developer", "lap trinh vien", "noun", "những anh chàng đẹp trai"));
		dic.put("play", new Vocabulary("play", "choi", "verb", "đừng quá ham chơi"));
		dic.put("lovely", new Vocabulary("lovely", "de thuong", "adj", "it's me"));
		dic.put("learn", new Vocabulary("learn", "hoc", "verb", "askdjhksdj"));

		return dic;
	}

	public static void addWord(Map<String, Vocabulary> dic, Vocabulary newVoc) {
		Objects.requireNonNull(newVoc);
		if (!(dic.containsKey(newVoc.getWord()))) {
			dic.put(newVoc.getWord(), newVoc);
		}

	}

	public static Vocabulary search(Map<String, Vocabulary> dic, String word) {

		return dic.get(word);
	}

}
