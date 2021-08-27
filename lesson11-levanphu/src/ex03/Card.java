package ex03;

public class Card {
	private String ran;
	private String suit;
	
	public Card() {
	}

	public Card(String ran, String suit) {
		this.ran = ran;
		this.suit = suit;
	}

	public String getRank() {
		return ran;
	}

	public void setRank(String ran) {
		this.ran = ran;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	@Override
	public String toString() {
		return "Card [" + suit + " " + ran + "]";
	
	}
}
