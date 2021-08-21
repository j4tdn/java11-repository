package ex03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Host {
	private List<Card> deck;

	public Host() {
		String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
		this.deck = new ArrayList<Card>();
		for (int i = 0; i < SUITS.length; i++) {
			for (int j = 0; j < RANKS.length; j++) {
				deck.add(new Card(SUITS[i], RANKS[j]));
			}
		}
	}

	public List<Card> getDeck() {
		return deck;
	}

	public void setDeck(List<Card> deck) {
		this.deck = deck;
	}

}
