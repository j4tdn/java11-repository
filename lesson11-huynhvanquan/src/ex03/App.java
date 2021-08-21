package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class App {
	public static void main(String[] args) {
		Host host = new Host();
		Player first = new Player(1, "Nam", new ArrayList<Card>());
		Player second = new Player(2, "Tran", new ArrayList<Card>());
		Player third = new Player(3, "Tien", new ArrayList<Card>());
		Player fouth = new Player(4, "Dan", new ArrayList<Card>());
		Collections.shuffle(host.getDeck());
		distribute(host.getDeck(), first, second, third, fouth);
		System.out.println(second.getName() + " shows cards!");
		first.showCards();
	}
	
	public static void distribute(List<Card> deck, Player ...players) {
		for (int i = 0; i < 13; i++) {
			players[0].getCardList().add(deck.get(deck.size() - 1));
			deck.remove(deck.size() - 1);
			
			players[1].getCardList().add(deck.get(deck.size() - 1));
			deck.remove(deck.size() - 1);
			
			players[2].getCardList().add(deck.get(deck.size() - 1));
			deck.remove(deck.size() - 1);
			
			players[3].getCardList().add(deck.get(deck.size() - 1));
			deck.remove(deck.size() - 1);
		}
	}
}


