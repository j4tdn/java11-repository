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
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		List<Transaction> ex01 = Ex01(transactions);
		CollectionUtils.printf(ex01);
		
		System.out.println("==================");
		
		List<Transaction> ex02 = Ex02(transactions);
		CollectionUtils.printf(ex02);
		
		System.out.println("==================");
		
		Set<String> ex03 = Ex03(traders);
		CollectionUtils.printf(ex03);
		
		System.out.println("==================");
		
		List<Trader> ex04 = Ex04(transactions);
		CollectionUtils.printf(ex04);
	}

	public static List<Transaction> Ex01(List<Transaction> transactions) {
		List<Transaction> results = new ArrayList<Transaction>();
		for (Transaction item : transactions) {
			if (item.getYear() == 2012) {
				results.add(item);
			}
		}
		results.sort(Comparator.comparing(Transaction::getValue));
		return results;
	}

	public static List<Transaction> Ex02(List<Transaction> transactions) {
		List<Transaction> results = new ArrayList<Transaction>();
		for (Transaction item : transactions) {
			if (item.getYear() == 2012) {
				results.add(item);
			}
		}
		results.sort(Comparator.comparing(Transaction::getValue));
		return results;
	}

	public static Set<String> Ex03(List<Trader> traders) {
		Set<String> results = new HashSet<String>();
		for (Trader trader : traders) {
			results.add(trader.getCity());
		}
		return results;
	}

	public static List<Trader> Ex04(List<Transaction> transactions) {
		List<Trader> results = new ArrayList<Trader>();
		for (Transaction item : transactions) {

			if (item.getTrader().getCity().equals("Cambridge")) {
				results.add(item.getTrader());
			}
		}
		results.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));
		return results;
	}
}