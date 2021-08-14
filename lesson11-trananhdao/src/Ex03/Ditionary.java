package Ex03;

import java.util.TreeMap;

public class Ditionary {
	public TreeMap<String, Word> dic;

    // Tao TreeMap bao gom tu va 
    public Ditionary() {
        dic = new TreeMap<String, Word>();
    }

    // Them tu moi vao tu dien
    public boolean addWord(Word word) {
        if (dic.put(word.getWord().toLowerCase(), word) != null) {
            return false;
        }
        return true;
    }

    // Tra tu
    public Word lookup(String word) {
        return dic.get(word);
    }

    public String toString() {
        String ret = "";
        for (Word w : dic.values()) {
            ret += w.toString() + "\n";
        }
        return ret;
    }
}
