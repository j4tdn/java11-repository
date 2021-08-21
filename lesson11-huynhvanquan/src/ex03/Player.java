package ex03;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private int id;
	private String name;
	private List<Card> cardList;
	public Player() {
		this.cardList = new ArrayList<Card>();
	}
	public Player(int id, String name, List<Card> cardList) {
		super();
		this.id = id;
		this.name = name;
		this.cardList = cardList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getCardList() {
		return cardList;
	}
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	public void showCards() {
		for (Card card : cardList) {
			System.out.println(card);
		}
	}

}
