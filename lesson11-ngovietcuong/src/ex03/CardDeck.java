package ex03;

import java.util.Random;

public class CardDeck {
	private int suit;
	private int rank;

	public CardDeck() {
		Random rd = new Random();

		this.suit = (int) (rd.nextInt(4));
		this.rank = (int) (rd.nextInt(13));
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		if(!(o instanceof CardDeck)) {
			return false;
		}
		CardDeck c = (CardDeck) o;
		return (this.rank == c.getRank() && this.suit == c.getSuit());
	}

	@Override
	public String toString() {
		String cards = "";
		switch (rank) {
		case 0:
			cards = "At";
			break;
		case 1:
			cards = "Hai";
			break;
		case 2:
			cards = "Ba";
			break;
		case 3:
			cards = "Bon";
			break;
		case 4:
			cards = "Nam";
			break;
		case 5:
			cards = "Sau";
			break;
		case 6:
			cards = "Bay";
			break;
		case 7:
			cards = "Tam";
			break;
		case 8:
			cards = "Chin";
			break;
		case 9:
			cards = "Muoi";
			break;
		case 10:
			cards = "J";
			break;
		case 11:
			cards = "Q";
			break;
		case 12:
			cards = "K";
			break;
		}

		switch (suit) {
		case 0:
			cards += " Co";
			break;
		case 1:
			cards += " Ro";
			break;
		case 2:
			cards += " Chuon";
			break;
		case 3:
			cards += " Bich";
			break;
		}
		return cards;
	}
}
