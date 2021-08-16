package example03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.ExUtils;

public class Ex03 {
	private static String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
	private static String[] suits = { "Hearts", "Spades", "Dimonds", "Clubs" };

	public static void main(String[] args) {
		List<Card> deck = getDeck();
		System.out.println("size: " + deck.size());
		ExUtils.printf(deck);

		List<Card> player1 = new ArrayList<>();
		List<Card> player2 = new ArrayList<>();
		List<Card> player3 = new ArrayList<>();
		List<Card> player4 = new ArrayList<>();

		System.out.println("================ Suffle =================");
		Collections.shuffle(deck);
		ExUtils.printf(deck);
		
		deal(player1, player2, player3, player4, deck);
		System.out.println("================== Player 1 ================");
		ExUtils.printf(player1);
		System.out.println("================== Player 2 ================");
		ExUtils.printf(player2);
		System.out.println("================== Player 3 ================");
		ExUtils.printf(player3);
		System.out.println("================== Player 4 ================");
		ExUtils.printf(player4);
		
	}

	private static List<Card> getDeck() {
		List<Card> deckCard = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 13; j++) {
				deckCard.add(new Card(ranks[j], suits[i]));
			}
		}

		return deckCard;
	}
	
	private static void deal(List<Card> player1, List<Card> player2, List<Card> player3, List<Card> player4, List<Card> deck) {
		for (int i = 0; i < deck.size(); i++) {
			if (i % 4 == 0) {
				player1.add(deck.get(i));
			} else if (i % 4 == 1) {
				player2.add(deck.get(i));
			} else if (i % 4 == 2) {
				player3.add(deck.get(i));
			} else {
				player4.add(deck.get(i));
			}
		}
	}
}
