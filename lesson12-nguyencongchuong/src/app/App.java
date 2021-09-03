package app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;

public class App {
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
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		transactions.stream()
			.filter(t -> t.getYear() == 2011)
			.sorted(Comparator.comparing(Transaction::getValue))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("=========================");
		
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city.
		transactions.stream()
			.filter(t -> t.getValue() > 300)
			.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("=========================");
		
		// 3. What are all the unique cities where the traders work?
		transactions.stream()
			.map(t -> t.getTrader().getCity())
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("=========================");
		
		// 4. Find all traders from Cambridge and sort them by name desc.
		traders.stream()
			.filter(t -> "Cambridge".equals(t.getCity()))
			//.sorted((t1, t2) -> t2.getName().compareTo(t1.getName()))
			.sorted(Comparator.comparing(Trader::getName).reversed())
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("=========================");
		
		// 5. Return a string of all traders’ names sorted alphabetically.
		traders.stream()
			.map(Trader::getName)
			.sorted()
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("=========================");
		
		// 6. Are any traders based in Milan?
		Boolean traderMilan = traders.stream()
			.anyMatch(t -> "Milan".equals(t.getCity()));
			
		System.out.println("Trader in Milan: " + traderMilan);
		System.out.println("=========================");
		
		// 7. Count the number of traders in Milan.
		long countTraderInMiLan = traders.stream()
			.filter(t -> "Milan".equals(t.getCity()))
			.count();
		
		System.out.println("The number of traders in Milan: " + countTraderInMiLan);
		System.out.println("=========================");
		
		// 8. Print all transactions’ values from the traders living in Cambridge.
		transactions.stream()
			.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
			.map(Transaction::getValue)
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("=========================");
		
		// 9. What’s the highest value of all the transactions?
		OptionalInt maxTransaction = transactions.stream()
			.mapToInt(Transaction::getValue)
			.max();
		if(maxTransaction.isPresent()) {
			System.out.println("The highest value of all the transactions: " + maxTransaction.getAsInt());
		}
		System.out.println("=========================");
		
		// 10. Find the transaction with the smallest value.
		OptionalInt minTransaction = transactions.stream()
				.mapToInt(Transaction::getValue)
				.min();
			if(maxTransaction.isPresent()) {
				System.out.println("The transaction with the smallest value: " + minTransaction.getAsInt());
			}
	}
}
