package demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.print.StreamPrintServiceFactory;

import bean.Trader;
import bean.Transaction;
import static utils.Utils.*;


public class App {
	public static void main(String[] args) {
		List<Transaction> transactions = utils.TransactionUtils.getTransactionAll();
		List<Trader> traders = utils.TraderUtils.getTraderAll();
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		System.out.println("1/------------------------------");
		List<Transaction> ex1 = transactions.stream()
				    .filter(y -> y.getYear() == 2011)
				    .sorted(Comparator.comparing(Transaction::getValue))
				    .collect(Collectors.toList());
		printf(ex1);
		
		//2. Find all transactions have value greater than 300 and sort them by trader’s city
		System.out.println("2/------------------------------");
		List<Transaction> ex2 = transactions.stream()
			.filter(v -> v.getValue() > 300)
			.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
			.collect(Collectors.toList());
		printf(ex2);
		
		// 3. What are all the unique cities where the traders work?
		System.out.println("3/------------------------------");
		List<String> ex3 = traders.stream()
			   .map(Trader::getCity)
			   .distinct()
			   .collect(Collectors.toList());
		printf(ex3);
		
		// 4. Find all traders from Cambridge and sort them by name desc.
		System.out.println("4/------------------------------");
		List<Trader> ex4 = traders.stream()
                .filter(city -> "Cambridge".equals(city.getCity()))
                .sorted(Comparator.comparing(Trader::getName).reversed())
                .collect(Collectors.toList());
		printf(ex4);

		// 5. Return a string of all traders’ names sorted alphabetically.
		System.out.println("5/------------------------------");
		List<String> ex5 = traders.stream()
				.map(Trader::getName)
				.sorted()
				.collect(Collectors.toList());
		printf(ex5);
		
		// 6. Are any traders based in Milan?
		System.out.println("6/------------------------------");
		boolean ex6 = traders.stream()
								 .anyMatch(t -> "Milan".equals(t.getCity()));
		System.out.println("Are any traders based in Milan? " + ex6);
		
		// 7. Count the number of traders in Milan.
		System.out.println("7/------------------------------");
		long ex7 = traders.stream()
				.filter(t -> "Milan".equals(t.getCity()))
				.count();
		System.out.println("Number of traders in Milan " + ex7);

		// 8. Print all transactions’ values from the traders living in Cambridge.
		System.out.println("8/------------------------------");
		List<Integer>  ex8 = transactions.stream()
                .filter(city -> "Cambridge".equals(city.getTrader().getCity()))
                .map(t -> t.getValue())
                .collect(Collectors.toList());
		printf(ex8);
		
		// 9. What’s the highest value of all the transactions?
		System.out.println("9/------------------------------");
		Integer ex9 = transactions.stream()
					.mapToInt(Transaction::getValue)
					.reduce(Integer.MIN_VALUE, Integer::max);
		System.out.println("The highest value of all the transactions: " + ex9);
		
		// 10. Find the transaction with the smallest value
		System.out.println("10/------------------------------");
		Integer ex10 = transactions.stream()
	              .mapToInt(v -> v.getValue())
	              .reduce(Integer.MAX_VALUE, Math::min);
		System.out.println("The transaction with the smallest value: " + ex10);
	}
}