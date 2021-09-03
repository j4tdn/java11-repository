package app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
		System.out.println("========== *** 1 *** ===============");
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		transactions.stream()
				    .filter(y -> y.getYear() == 2011)
				    .sorted(Comparator.comparing(Transaction::getValue))
				    .collect(Collectors.toList())
				    .forEach(System.out::println);
		
		System.out.println("============*** 2 ***===============");
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city
		transactions.stream()
			.filter(v -> v.getValue() > 300)
			.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
			.collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("=============*** 3 ***==============");
		// 3. What are all the unique cities where the traders work?
		traders.stream()
			   .map(Trader::getCity)
			   .distinct()
			   .collect(Collectors.toList())
			   .forEach(System.out::println);
		
		System.out.println("=============*** 4 ***==============");
		// 4. Find all traders from Cambridge and sort them by name desc.
		traders.stream()
			   .filter(t -> ("Cambridge").equals(t.getCity()))
			   .sorted(Comparator.comparing(Trader::getName))
			   .collect(Collectors.toList())
			   .forEach(System.out::println);
		
		System.out.println("=============*** 5 ***==================");
		// 5. Return a string of all traders’ names sorted alphabetically.
		List<String> allTraders = traders.stream()
										 .map(Trader::getName)
										 .sorted()
										 .collect(Collectors.toList());
		for (String trader : allTraders) {
			System.out.println(trader);
		}
		
		System.out.println("===============*** 6 ***================");
		// 6. Are any traders based in Milan?
		boolean isMilan = traders.stream()
								 .anyMatch(t -> "Milan".equals(t.getCity()));
		System.out.println("Are any traders based in Milan?: " + isMilan);
		
		System.out.println("================*** 7 ***=============");
		// 7. Count the number of traders in Milan.
		long n = traders.stream()
						.filter(t -> "Milan".equals(t.getCity()))
					    .count();
					    
		System.out.println("number of traders in Milan: " + n);
		
		System.out.println("================*** 8 ***=================");
		// 8. Print all transactions’ values from the traders living in Cambridge.
		transactions.stream()
					.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
					.map(Transaction::getValue)
					.collect(Collectors.toList())
					.forEach(System.out::println);
		
		System.out.println("===============*** 9 ***=================");
		// 9. What’s the highest value of all the transactions?
		Integer max = transactions.stream()
					.mapToInt(Transaction::getValue)
					.reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println("the highest value of all the transactions is: " + max);
		
		System.out.println("==============*** 10 ***=================");
		// 10. Find the transaction with the smallest value
		Optional<Transaction> minTrans = transactions.stream()
										   .reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		minTrans.ifPresent(System.out::println);
	}
}	
