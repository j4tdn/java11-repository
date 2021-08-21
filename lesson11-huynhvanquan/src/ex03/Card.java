package ex03;

public class Card {
	private String suit;
	private String ranks;

	public Card(String suit, String ranks) {
		super();
		this.suit = suit;
		this.ranks = ranks;
	}
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getRanks() {
		return ranks;
	}
	public void setRanks(String ranks) {
		this.ranks = ranks;
	}
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", ranks=" + ranks + "]";
	}
}
