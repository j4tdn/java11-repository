package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
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
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// Q1: Find all transaction in 2012 and sort them by value
		List<Transaction> ty2012 = new ArrayList<Transaction>();
		for (Transaction transaction : transactions) {
			if (transaction.getYear() == 2012) {
				ty2012.add(transaction);
			}

		}

		ty2012.sort(Comparator.comparing(Transaction::getValue));
		CollectionUtils.printf(ty2012);

		System.out.println("===============");

		// Q2:
		List<Transaction> tvg300 = new ArrayList<Transaction>();
		for (Transaction transaction : transactions) {
			if (transaction.getValue() > 300) {
				tvg300.add(transaction);
			}

		}

		Comparator<Transaction> comp = new Comparator<Transaction>() {
			@Override
			public int compare(Transaction o1, Transaction o2) {

				return o1.getTrader().getCity().compareTo(o1.getTrader().getCity());
			}
		};
		tvg300.sort(comp);
		CollectionUtils.printf(tvg300);

		System.out.println("===============");

		// Q3: find all name'city of traders work
		Set<String> cities = new HashSet();

		for (Trader trader : traders) {
			cities.add(trader.getCity());
		}

		for (String city : cities) {
			System.out.println(city);
		}
		System.out.println("==============================");

		
		//Q4 find all trader from Cambridge
		List<Trader>  tcam = new ArrayList<Trader>();
		for(Trader trader: traders) {
			// lay chuoi.equal se ko gap th nullpointException
			if(("Cambridge").equals(trader.getCity())) {
				tcam.add(trader);
			}
		}
		
		tcam.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));
		CollectionUtils.printf(tcam);
		
	}

}