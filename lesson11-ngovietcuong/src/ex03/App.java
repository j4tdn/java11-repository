package ex03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
	public static void main(String[] args) {
		List<CardDeck> deck = new ArrayList<>();
		shuffleCards(deck);
		
		System.out.println("===== Divided By 4 People =====");
		
		printfCard(deck);
	}
	
	public static void printfCard(List<CardDeck> cards){
		int count = 0;
		for(CardDeck card: cards) {
			if(count % 13 == 0) {
				System.out.println("\n==== Player " + (count/13 + 1) + " ====");
			}
			System.out.println(card);
			count++;
		}
	}
	
	public static List<CardDeck> shuffleCards(List<CardDeck> cards){
		int count = 0;
		do {
			CardDeck card = new CardDeck();
			if (!cards.contains(card)) {
				cards.add(card);
				count++;
			}
		} while (count < 52);
		
		Collections.shuffle(cards);
		
		return cards;
	}
}
