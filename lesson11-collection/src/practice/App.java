package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class App {
	// traders executing transactions
	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// 1.
		List<Transaction> ty2012 = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getYear() == 2012) {
				ty2012.add(transaction);
			}
		}
		ty2012.sort(Comparator.comparing(Transaction::getValue));

		// 2.
		List<Transaction> tv300 = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getValue() > 300) {
				tv300.add(transaction);
			}
		}

		Comparator<Transaction> c = new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o1.getTrader().getCity().compareTo(o2.getTrader().getCity());
			}
		};
		tv300.sort(c);
		
		// 3.
		Set<String> cities = new HashSet<>();
		for (Trader trader : traders) {
			cities.add(trader.getCity());
		}
		
		// 4.
		List<Trader> trc = new ArrayList<>();
		for (Trader trader : traders) {
			if ("Cambridge".equals(trader.getName())) {
				trc.add(trader);
			}
		}
		trc.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));

	}

}