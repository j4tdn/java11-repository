package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import Utils.collectionUtils;
import bean.Trader;
import bean.Transaction;

public class App {
	public static void main(String[] args) {
		List<Transaction> transactions = Utils.getUtils.getTransactionAll();
		List<Trader> traders = Utils.getUtils.getTraderAll();

		System.out.println("1.Find all transactions in the year 2011 and sort them by value (small to high).");
		List<Transaction> ex1 = transactions.stream()
										    .filter(y -> y.getYear() == 2011)
			                            	.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		collectionUtils.Printf(ex1);
		

		System.out.println("\n 2. Find all transactions have value greater than 300 and sort them by "
				+ "trader’s city");
		List<Transaction> ex2 = transactions.stream()
			 	                            .filter(vl -> vl.getValue() > 300)
			 	                            .sorted((v1, v2) -> v1.getTrader().getCity().compareTo(v2.getTrader().getCity()))
			                            	.collect(Collectors.toList());
		collectionUtils.Printf(ex2);
		
		
		System.out.println("\n 3. What are all the unique cities where the traders work?");
		List<String> ex3 = traders.stream()
				                  .map(city -> city.getCity())
				                  .distinct()
				                  .collect(Collectors.toList());
		collectionUtils.Printf(ex3);
		
		System.out.println("\n 4. Find all traders from Cambridge and sort them by name desc.");
		List<Trader> ex4 = traders.stream()
				                  .filter(city -> "Cambridge".equals(city.getCity()))
				                  .sorted(Comparator.comparing(Trader::getName).reversed())
				                  .collect(Collectors.toList());
		collectionUtils.Printf(ex4);
		
		
		System.out.println("\n 5. Return a string of all traders’ names sorted alphabetically.");
		List<String> ex5 = traders.stream()
				                  .map(Trader::getName)
				                  .sorted()
				                  .collect(Collectors.toList());
		collectionUtils.Printf(ex5);
		
		
		System.out.println("\n 6. Are any traders based in Milan?");
		boolean ex6 = traders.stream()
				             .anyMatch(city -> "Milan".equals(city.getCity()));
		System.out.println(ex6);
		
		
		System.out.print("\n 7. Count the number of traders in Milan: ");
		long ex7 = traders.stream()
				         .filter(city -> "Milan".equals(city.getCity()))
				         .count();
		System.out.println(ex7);
		
	
		System.out.println("\n 8. Print all transactions’ values from the traders living in Cambridge.");
		List<Integer>  ex8 = transactions.stream()
				                  .filter(city -> "Cambridge".equals(city.getTrader().getCity()))
				                  .map(t -> t.getValue())
				                  .collect(Collectors.toList());
		collectionUtils.Printf(ex8);
		
		System.out.println("\n 9. What’s the highest value of all the transactions?");
		int ex9 = transactions.stream()
				              .mapToInt(v -> v.getValue())
				              .reduce(Integer.MIN_VALUE, Math::max);
		System.out.println(ex9);
		
		System.out.println("\n 10. Find the transaction with the smallest value.");
		int ex10 = transactions.stream()
	              .mapToInt(v -> v.getValue())
	              .reduce(Integer.MAX_VALUE, Math::min);
        System.out.println(ex10);
	}
}
