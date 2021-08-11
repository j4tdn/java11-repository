package ex03;

/**
 * Due to anti-cheating, the value of the card is assigned only once at
 * initialization
 * 
 * @author hai
 *
 */
public class Card {
	private Name name;
	private Suit suit;

	public Card(Name name, Suit suit) {
		this.name = name;
		this.suit = suit;
	}

	public Name getName() {
		return name;
	}

	public Suit getSuit() {
		return suit;
	}

	@Override
	public String toString() {
		return "" + suit + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!(obj instanceof Card)) {
			return false;
		}

		Card that = (Card) obj;

		if (this.name.equals(that.name) && this.suit.equals(that.suit)) {
			return true;
		}

		return false;
	}
}

enum Name {
	TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"), EIGHT("8"), NIGHT("9"), TEN("10"), JACK("J"),
	QUEEN("Q"), KING("K"), ACE("A");

	private String value;

	private Name(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.value;
	}

}

enum Suit {
	HEART('♥'), DIAMOND('♦'), CLUB('♣'), SPADE('♠');

	private char value;

	private Suit(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "" + this.value;
	}
}