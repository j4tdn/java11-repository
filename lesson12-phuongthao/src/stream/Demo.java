package stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.sun.net.httpserver.Filter;

public class Demo {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader biran = new Trader("Biran", "Cambridge");

		List<Transaction> transactions = Arrays.asList(

				new Transaction(biran, 2011, 300), 
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), 
				new Transaction(mario, 2012, 710), 
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

		List<Trader> traders = Arrays.asList(raoul, mario, alan, biran);

		// Q1. Find all transactions in the year 2011 and sort them by value (small to
		// high).
		List<Transaction> transactions2011 = transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		// printf(transactions2011);

		// Q2. Find all transactions have value greater than 300 and sort them by
		// trader’s city

		List<Transaction> valueTranstationsGreater300 = transactions.stream().filter(t -> t.getValue() > 300)
				.sorted(Comparator.comparing(t -> t.getTrader().getCity())).collect(Collectors.toList());

		// printf(valueTranstationsGreater300);

		// Q3. What are all the unique cities where the traders work
		List<String> allCities = traders.stream().map(t -> t.getCity()).collect(Collectors.toList());
		// printf(allCities);

		// Q4 Find all traders from Cambridge and sort them by name desc
		// todo...............
		List<Trader> traderCambridge = traders.stream().filter(t -> t.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
		// printf(traderCambridge);

		// Q5. Return a string of all traders's names sorted alphabetically
		List<String> tradersName = traders.stream().map(t -> t.getName()).sorted().collect(Collectors.toList());

		String names = String.join(" ", tradersName);
		// printf(tradersName);
		// System.out.println(names);

		// Q6. Are any traders based in Milan?
		boolean tradersInMilan = traders.stream().anyMatch(t -> t.getCity().equals("Milan"));
		// System.out.println(tradersInMilan);

		// Q7. Count the number of traders in Milan
		long numberTradersMinlan = traders.stream().filter(t -> t.getCity().equals("Milan")).count();
		// System.out.println(numberTradersMinlan);

		// Q8. Print all transactions’ values from the traders living in Cambridge.
		List<Transaction> transactionInCambridge = transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge")).collect(Collectors.toList());
		// printf(transactionInCambridge);

		// 9. What’s the highest value of all the transactions?
		List<Integer> value = transactions.stream().map(transaction -> transaction.getValue())
				.collect(Collectors.toList());
		
		Optional<Integer> hightestValue = value.stream().reduce((a, b) -> a > b ? a : b);
		System.out.println(hightestValue.orElse(0));

		// 10. What’s the smallest value of all the transactions?
		Optional<Integer> smallestValue = value.stream().reduce((a, b) -> a < b ? a : b);
		System.out.println(smallestValue.orElse(0));
	}

	public static <E> void printf(Collection<E> elements) {
		for (E e : elements) {
			System.out.println(e);
		}
	}

}
