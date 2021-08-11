package ex03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Due to anti-cheating from the deck's distributor, We cannot provide deck's
 * checking methods
 * 
 * @author hai
 *
 */
public class Deck {
	private final int size = 52;
	private List<Card> myDeck;
	private int indexOfLastCard = 51;

	public Deck() {
		// initial a fixed-size list
		myDeck = Arrays.asList(new Card[size]);
		initDeck();
	}

	public void shuffle() {
		Collections.shuffle(myDeck);
	}

	/**
	 * Pop the first card out of the deck
	 * 
	 * @return a first card in the deck
	 */
	public Card pop() {
		if (numberRemainCards() > 0) {
			return myDeck.get(indexOfLastCard--);
		}
		return null;
	}

	public int numberRemainCards() {
		return indexOfLastCard + 1;
	}

	/**
	 * Each player are distributed 13 cards in maximum
	 * 
	 * @param players
	 * @return number of remaining cards in deck
	 */
	public int distribute(Player... players) {
		distribute: for (int i = 0; i < Player.fullSizeInHand; i++) {
			for (Player player : players) {
				player.holdCard(this.pop());
				if (this.numberRemainCards() == 0) {
					break distribute;
				}
			}
		}
		return numberRemainCards();
	}

	private void initDeck() {
		for (int i = 0; i < size; i++) {
			int serialNumber = (i + 1);
			int value = serialNumber % 13;
			Name name = null;
			Suit suit = null;

			// Set name
			switch (value) {
			case 1:
				name = Name.ACE;
				break;
			case 2:
				name = Name.TWO;
				break;
			case 3:
				name = Name.THREE;
				break;
			case 4:
				name = Name.FOUR;
				break;
			case 5:
				name = Name.FIVE;
				break;
			case 6:
				name = Name.SIX;
				break;
			case 7:
				name = Name.SEVEN;
				break;
			case 8:
				name = Name.EIGHT;
				break;
			case 9:
				name = Name.NIGHT;
				break;
			case 10:
				name = Name.TEN;
				break;
			case 11:
				name = Name.JACK;
				break;
			case 12:
				name = Name.QUEEN;
				break;
			case 0:
				name = Name.KING;
				break;
			default:
				break;
			}

			// Set suit
			switch (i / 13) {
			case 0:
				suit = Suit.SPADE;
				break;
			case 1:
				suit = Suit.CLUB;
				break;
			case 2:
				suit = Suit.DIAMOND;
				break;
			case 3:
				suit = Suit.HEART;
				break;
			default:
				break;
			}
			myDeck.set(i, new Card(name, suit));
		}
	}
}
