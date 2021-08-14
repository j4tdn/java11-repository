package Ex04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card_List {
	private List<Card> list;

    public Card_List() {
        list = new ArrayList<Card>();
        int count = 0;
        do {
            Card c = new Card();
            if (!list.contains(c)) {
                list.add(c);
                count++;
            }
        } while (count < 52);

    }

    public void shuffleCardPack() {
        Collections.shuffle(list);
    }

    public String toString() {
        String ret = "";
        for (Card c : list) {
            ret += c.toString() + "\n";
        }
        return ret;
    }

}
