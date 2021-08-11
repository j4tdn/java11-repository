package ex03;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Player {
	public static final int fullSizeInHand = 13;

	private String name;
	private List<Card> handCards;
	private int index = 0;

	public Player(String name) {
		this.name = name;
		// fixed-size
		handCards = Arrays.asList(new Card[fullSizeInHand]);
	}

	public int numberOfCards() {
		return index;
	}

	/**
	 * 
	 * @return list of cards in hand
	 */
	public List<Card> getHandCards() {
		return handCards.subList(0, index);
	}

	/**
	 * 
	 * @param card
	 * @return true if the number of cards in hand less than 13
	 */
	public boolean holdCard(Card card) {
		if (index < fullSizeInHand) {
			handCards.set(index++, card);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "[" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Player)) {
			return false;
		}

		Player that = (Player) obj;

		return this.name == that.name;
	}

}
