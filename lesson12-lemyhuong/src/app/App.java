package app;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bean.Trader;
import bean.Transaction;
import utils.CollectionUtils;
import utils.TransactionUtils;

public class App {
	public static void main(String[] args) {
		List<Transaction> transactions = TransactionUtils.getAll();
		
		// 1. Find all transactions in the year 2011 and sort them by value (small to high).
		System.out.println("======= 1. Transactions in the year 2011 =========");
		List<Transaction> trans2021 = transactions.stream()
									              .filter(y -> y.getYear() == 2011)
									              .sorted(Comparator.comparing(Transaction::getValue))
									              .collect(Collectors.toList());
		trans2021.forEach(System.out::println);
		
		// 2. Find all transactions have value greater than 300 and sort them by trader’s city
		System.out.println();
		System.out.println("======= 2. Transactions have value greater than 300 ========");
		List<Transaction> transGte300 = transactions.stream()
												   	.filter(v -> v.getValue() > 300)
												   	.sorted((c1,c2) -> c1.getTrader().getCity().compareTo(c2.getTrader().getCity()))
												   	.collect(Collectors.toList());
		CollectionUtils.printf(transGte300);
		
		// 3. What are all the unique cities where the traders work?
		System.out.println();
		System.out.println("======= 3. Unique City ========");
		List<String> tranderUniqueCity = transactions.stream()
													 .map(city -> city.getTrader().getCity())
													 .distinct()
													 .collect(Collectors.toList());
		
		CollectionUtils.printf(tranderUniqueCity);
		
		// 4. Find all traders from Cambridge and sort them by name desc
		System.out.println();
		System.out.println("======= 4. Traders from Cambridge ========");
		
		List<Trader> traderFromCambridge = transactions.stream()
													   .filter(city -> "Cambridge".equals(city.getTrader().getCity()))
													   .sorted((n1,n2) -> n2.getTrader().getName().compareTo(n1.getTrader().getName()))
													   .map(n -> n.getTrader()).distinct()
													   .collect(Collectors.toList());
		CollectionUtils.printf(traderFromCambridge);	
		
		// 5. Return a string of all traders’ names sorted alphabetically
		System.out.println();
		System.out.println("======= 5. All traders's name sorted ========");
		
		List<String> traderName = transactions.stream()
											  .map(n -> n.getTrader().getName())
											  .sorted().distinct()
											  .collect(Collectors.toList());
		
		CollectionUtils.printf(traderName);
		
		// 6. Are any traders based in Milan?
		System.out.println();
		System.out.println("======= 6. Traders based in Milan ========");
		
		boolean traderMilan = transactions.stream()
										  .anyMatch(city -> "Milan".equals(city.getTrader().getCity()));
		
		System.out.println(traderMilan);
		
		// 7. Count the number of traders in Milan
		System.out.println();
		System.out.println("======= 7. N.o tranders in Milan ========");
		
		long numberTradersMilan = transactions.stream()
									   		  .filter(city -> "Milan".equals(city.getTrader().getCity()))
									   		  .count();
		
		System.out.println(numberTradersMilan);
		
		// 8. Print all transactions’ values from the traders living in Cambridge
		System.out.println();
		System.out.println("======= 8. Transactions’ values from the traders living in Cambridge ========");
		
		List<Integer> valueTrans = transactions.stream()
				    						   .filter(city -> "Cambridge".equals(city.getTrader().getCity()))
				    						   .map(v -> v.getValue())
				    						   .collect(Collectors.toList());
		CollectionUtils.printf(valueTrans);
		
		// 9. What’s the highest value of all the transactions?
		System.out.println();
		System.out.println("======= 9. The highest value of transactions ========");
		
		Optional<Integer> maxValue = transactions.stream()
												 .sorted(Comparator.comparing(Transaction::getValue).reversed())
												 .map(v -> v.getValue())
												 .findFirst();
		
		System.out.println(maxValue);
		
		// 10. What’s the smallest value of all the transactions?
		System.out.println();
		System.out.println("======= 10. The smallest value of transactions ========");
		Optional<Integer> minValue = transactions.stream()
												 .sorted(Comparator.comparing(Transaction::getValue))
												 .map(v -> v.getValue())
												 .findFirst();
		System.out.println(minValue);									 
				
	}
}












