package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.CollectionUtils;

public class Ex03 {
	private static String[] orderByCard = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private static String[] propertites = { "Cơ", "Rô", "Chuồn", "Bích" };

	public static void main(String[] args) {
		List<Card> deckOfCards = getDeckOfCards();
		CollectionUtils.printf(deckOfCards);

		System.out.println("======== Shuffle ========");
		Collections.shuffle(deckOfCards);

		List<Card> player1 = new ArrayList<>();
		List<Card> player2 = new ArrayList<>();
		List<Card> player3 = new ArrayList<>();
		List<Card> player4 = new ArrayList<>();

		for (int i = 0; i < deckOfCards.size(); i++) {
			if (i % 4 == 0) {
				player1.add(deckOfCards.get(i));
			}
			if (i % 4 == 1) {
				player2.add(deckOfCards.get(i));
			}
			if (i % 4 == 2) {
				player3.add(deckOfCards.get(i));
			} else {
				player4.add(deckOfCards.get(i));
			}
		}

	}

	private static List<Card> getDeckOfCards() {
		List<Card> deckOfCards = new ArrayList<>();
		for (int i = 0; i < propertites.length; i++) {
			for (int j = 0; j < orderByCard.length; j++) {
				deckOfCards.add(new Card(propertites[i], orderByCard[j]));
			}
		}

		return deckOfCards;
	}

}
