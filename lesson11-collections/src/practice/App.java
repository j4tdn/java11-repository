package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import ultils.CollectionUtils;

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

		// Q1: Find all transaction in the year 2011 and sort them by value
		List<Transaction> q1 = new ArrayList<>();
		for (Transaction tran : transactions) {
			if (tran.getYear() == 2012) {
				q1.add(tran);
			}
		}
		q1.sort(Comparator.comparing(Transaction::getValue));
		System.out.println("== Find all transaction in the year 2011 and sort them by value ==");
		CollectionUtils.printf(q1);

		// Q2: Find all transactions have value greater 300 and sort them by city
		List<Transaction> q2 = new ArrayList<>();
		for (Transaction tran : transactions) {
			if (tran.getValue() > 300) {
				q2.add(tran);
			}
		}
		q2.sort((o1, o2) -> o1.getTrader().getCity().compareTo(o1.getTrader().getCity()));
		System.out.println("== Find all transactions have value greater 300 and sort them by city ==");
		CollectionUtils.printf(q2);

		// Q3: What are all the unique cities where the traders work
		Set<String> q3 = new HashSet<>();
		for (Trader trader : traders) {
			q3.add(trader.getCity());
		}
		System.out.println("== What are all the unique cities where the traders work ==");
		CollectionUtils.printf(q3);

		// Q4: Find all traders from Cambridge and sort them by name descending
		Set<Trader> q4 = new TreeSet<Trader>(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));
		for (Trader trader : traders) {
			if ("Cambridge".equals(trader.getCity())) {
				q4.add(trader);
			}
		}
		System.out.println("== Find all traders from Cambridge and sort them by name descending ==");
		CollectionUtils.printf(q4);

		// Q5: Return a string of all trader's names sorted alphabetically
		List<String> q5 = new ArrayList<>();
		for (Trader trader : traders) {
			q5.add(trader.getName());
		}
		q5.sort(Comparator.comparing(Function.identity()));
		System.out.println("== Return a string of all trader's names sorted alphabetically ==");
		CollectionUtils.printf(q5);

		// Q6: Are any traders based in Milan
		int q6 = 0;
		for (Trader trader : traders) {
			if (("Milan".equals(trader.getCity()))) {
				q6++;
			}
		}
		System.out.println("== Are nay traders based in Milan ==");
		System.out.println(q6);

		// Q7: Count the number of traders in Milan
		// Q8: Print all transaction's values from the traders living in Cambridge
		List<Transaction> q8 = new ArrayList<>();
		for (Transaction tran : transactions) {
			if ("Cambridge".equals(tran.getTrader().getCity())) {
				q8.add(tran);
			}
		}
		System.out.println("== Print all transaction's values from the traders living in Cambridge ==");
		CollectionUtils.printf(q8);

		// Q9: What's the highest value of all the transactions?
		int q9 = 0;
		for (Transaction tran : transactions) {
			if (tran.getValue() > q9) {
				q9 = tran.getValue();
			}
		}
		System.out.println("== What's the highest value of all the transactions? ==");
		System.out.println(q9);

		// Q10: Find the transaction with the samllest value
		
	}
}
