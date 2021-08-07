package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import utils.CollectionUtils;

public class App {
	// traders executing transactions
	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);

		List<Transaction> ty2012 = new ArrayList<>();
		for (Transaction transaction: transactions) {
			if (transaction.getYear() == 2012) {
				ty2012.add(transaction);
			}
		}

		ty2012.sort(Comparator.comparing(Transaction::getValue));
		CollectionUtils.printf(ty2012);

		List<Transaction> ty300 = new ArrayList<>();
		for (Transaction transaction: transactions) {
			if (transaction.getValue() > 300) {
				ty300.add(transaction);
			}
		}

		ty300.sort((o1,o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity()));
		CollectionUtils.printf(ty300);
		
		Set<String> cities = new HashSet<>();
		for (Trader trader: traders) {
			cities.add(trader.getCity());
		}
		
		for (String city: cities) {
			System.out.println(city);
		}
		
		List<Trader> trc = new ArrayList<>();
		for (Trader trader: traders) {
			if ("Cambridge".equals(trader.getCity())) {
				trc.add(trader);
			}
		}

		trc.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));
		CollectionUtils.printf(trc);
	}
}