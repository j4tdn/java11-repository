package ex03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
	private Utils() {
	}
	
	private static void print(List<Card> deck) {
		for (Card card: deck) {
			System.out.println(card);
		}
	}

}
