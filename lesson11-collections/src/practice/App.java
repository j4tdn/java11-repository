package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		
		// Q1:
		List<Transaction> ty2021 = new ArrayList<>();
		for(Transaction transaction: transactions) {
			if(transaction.getYear() == 2012) {
				ty2021.add(transaction);
			}
		}

		ty2021.sort(Comparator.comparing(Transaction::getValue));
		CollectionUtils.printf(ty2021);
		
		// Q2:
		List<Transaction> tv300 = new ArrayList<>();
		for(Transaction transaction: transactions) {
			if(transaction.getValue() > 300) {
				tv300.add(transaction);
			}
		}
		Comparator<Transaction> comp = new Comparator<Transaction>() {

			@Override
			public int compare(Transaction t1, Transaction t2) {
				return t1.getTrader().getCity().compareTo(t1.getTrader().getCity());
			}
		};
		tv300.sort(comp);
		CollectionUtils.printf(tv300);
		
		System.out.println("==========================");
		
		// Q3:
		Set<String> cities = new HashSet<>();
		for(Trader trader: traders) {
			cities.add(trader.getCity());
		}
		
		for(String city: cities) {
			System.out.println(city);
		}
		
		System.out.println("====================");
		
		// Q4:
		List<Trader> trc = new ArrayList<>();
		for(Trader trader: traders) {
			if("Cambridge".equals(trader.getCity())) {
				trc.add(trader);
			}
		}
		trc.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));
		CollectionUtils.printf(trc);
	}
		
}