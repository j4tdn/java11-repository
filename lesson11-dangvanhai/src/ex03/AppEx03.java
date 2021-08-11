package ex03;

public class AppEx03 {
	public static void main(String[] args) {
		// Create deck and shuffle
		Deck deck = new Deck();
		deck.shuffle();

		// Create players and distribute the cards
		Player player1 = new Player("William");
		Player player2 = new Player("LinColn");
		Player player3 = new Player("James");
		Player player4 = new Player("Austin");
		System.out.println("Number of remaining cards in the deck: " + deck.numberRemainCards());
		System.out.println("============> Distribute <============");
		int numberRemainCards = deck.distribute(player1, player2, player3, player4);
		System.out.println("Number of remaining cards in the deck: " + numberRemainCards);

		// Show player's cards
		System.out.println("======================================");
		showCards(player1, player2, player3, player4);

	}

	private static void showCards(Player... players) {
		// Show player's name
		System.out.println();
		for (Player player : players) {
			System.out.printf(String.format("%-15s", player));
		}

		// Show player's cards
		for (int i = 0; i < Player.fullSizeInHand; i++) {
			System.out.println();
			for (Player player : players) {
				String cardValue = "";
				try {
					cardValue = player.getHandCards().get(i).toString();
				} catch (Exception e) {
				}
				System.out.printf(String.format("%-15s", " " + cardValue));
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
