package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;
import utils.GetUtils;

public class App {
	public static void main(String[] args) {
		List<Trader> traders = GetUtils.getTraderAll();
		List<Transaction> transactions = GetUtils.getTransactionAll();
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		transactions.stream()
					.filter(t -> t.getYear() == 2011)
					.sorted(Comparator.comparing(Transaction::getValue))
					.collect(Collectors.toList())
					.forEach(System.out::println);
		System.out.println("===========================");
		
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city
		transactions.stream()
					.filter(t -> t.getValue() > 300)
					.sorted((o1, o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity()))
					.collect(Collectors.toList())
					.forEach(System.out::println);
		System.out.println("===========================");
		
		// 3. What are all the unique cities where the traders work?
		traders.stream()
			   .filter(trader -> Collections.frequency(traders, trader.getCity()) == 1)
			   .collect(Collectors.toList())
			   .forEach(System.out::println);
		System.out.println("===========================");
		
		// 4. Find all traders from Cambridge and sort them by name desc.
		traders.stream()
			   .filter(trader -> "Cambridge".equals(trader.getCity()))
			   .sorted(Comparator.comparing(Trader::getName).reversed())
			   .collect(Collectors.toList())
			   .forEach(System.out::println);
		System.out.println("===========================");
		
		// 5. Return a string of all traders’ names sorted alphabetically.
		traders.stream()
			   .map(Trader::getName)
			   .sorted()
			   .collect(Collectors.toList())
			   .forEach(System.out::println);
		System.out.println("===========================");
		
		// 6. Are any traders based in Milan?
		boolean anyMilanCity = traders.stream()
			                         .anyMatch(trader -> "Milan".equals(trader.getCity()));
		System.out.println("Are any traders based in Milan? " + anyMilanCity);
		System.out.println("===========================");
		
		// 7. Count the number of traders in Milan.
		long countMilan = traders.stream()
								.filter(trader -> "Milan".equals(trader.getCity()))
								.count();
		System.out.println("the number of traders in Milan: " + countMilan);
		System.out.println("===========================");
		
		// 8. Print all transactions’ values from the traders living in Cambridge.
		transactions.stream()
					.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
					.map(Transaction::getValue)
					.collect(Collectors.toList())
					.forEach(System.out::println);
		System.out.println("===========================");
		
		// 9. What’s the highest value of all the transactions?
		Optional<Integer> highestValue = transactions.stream()
						.sorted(Comparator.comparing(Transaction::getValue).reversed())
						.map(Transaction::getValue)
						.findFirst();
	    highestValue.ifPresent(System.out::println);
		System.out.println("===========================");
		
		// 10. Find the transaction with the smallest value.
		Optional<Transaction> smallTransactionValue = transactions.stream()
					.sorted(Comparator.comparing(Transaction::getValue))
					.findFirst();
		smallTransactionValue.ifPresent(System.out::println);
		
	}
}
