package trans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul,mario,alan,brian);
		
		List<Transaction> trans = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		
		//1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction>  yearAndValue = trans.stream()
	   		 .filter(t -> t.getYear() == 2011)
	   		 .sorted(Comparator.comparing(Transaction::getValue))
	   		 .collect(Collectors.toList());
	 	printf(yearAndValue);
	 	System.out.println("=======================================");
	   		 
	   	//2.Find all transactions have value greater than 300 and sort them by trader’s city	 
		 List<Transaction> greaterAndCity = trans.stream()
					.filter(t -> t.getValue() > 300)
					.sorted((a,b) -> a.getTrader().getCity().compareTo(b.getTrader().getCity()))
					.collect(Collectors.toList());
		 printf(greaterAndCity);
		 System.out.println("=======================================");
		
		 //3. What are all the unique cities where the traders work?
		 List<String> uniqueCities = traders.stream()
				 .map(Trader::getCity).distinct().collect(Collectors.toList());
			printf(uniqueCities);	 
			System.out.println("=======================================");
	
		//4. Find all traders from Cambridge and sort them by name desc.	
			List<Trader> fromCam = traders.stream()
					.filter(t -> "Cambridge".equals(t.getCity())) 
					.sorted(Comparator.comparing(Trader::getName,Comparator.reverseOrder()))
					.collect(Collectors.toList());
				printf(fromCam);
			System.out.println("=======================================");
		
		//5. Return a string of all traders’ names sorted alphabetically.
			List<String> traderName = traders.stream()
					.map(Trader::getName) 
					.sorted()
					.collect(Collectors.toList());
			printf(traderName);
			System.out.println("=======================================");
			
		//6. Are any traders based in Milan?	
			boolean inMi = traders.stream()
						.anyMatch(t->"Milan".equals(t.getCity()));
			
			System.out.println(inMi);
			System.out.println("=======================================");
			
		//7. Count the number of traders in Milan.	
			long inMilan = traders.stream()
					.filter(t -> "Milan".equals(t.getCity()))
					.count();
					
			System.out.println(inMilan);
			System.out.println("=======================================");
			
		//8. Print all transactions’ values from the traders living in Cambridge.
			List<Integer> valueInCam = trans.stream()
											.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
											.map(Transaction::getValue)
											.collect(Collectors.toList());
										
			printf(valueInCam);
			System.out.println("=======================================");
			
			
			//9. What’s the highest value of all the transactions?
			int highestValue = trans.stream()
					.map(Transaction::getValue)
				    .reduce(Integer.MIN_VALUE, Integer::max);
			
			System.out.println("highestValue: " +highestValue);
				System.out.println("=======================================");
				
	     	//10. Find the transaction with the smallest value.
				Optional<Transaction> smallestValue = trans.stream()
													  .reduce(App::minValue);
													 
				smallestValue.ifPresent(System.out::println);
				

	}
	public static Transaction minValue(Transaction t1, Transaction t2) {
		return t1.getValue() < t2.getValue() ? t1: t2;
	}
	
	private static <T> void printf(List<T> list) {
		list.forEach(System.out::println);
	}
}
