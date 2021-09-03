package exercies;

import java.util.Arrays;
import static java.util.Comparator.*;
import java.util.List;
import java.util.OptionalInt;
import static java.util.function.Function.*;
import static java.util.stream.Collectors.*;


public class App {
	public static void main(String[] args) {
		List<Transaction> transactions = initData();
		
		//	1. Find all transactions in the year 2011 and sort them by value (small to high).
		List<Transaction> q1 = transactions.stream().filter(e -> (e.getYear() == 2011))
				.sorted(comparing(Transaction::getValue)).collect(toList());
		
		//	2. Find all transactions have value greater than 300 and sort them by trader’s city
		List<Transaction> q2 = transactions.stream().filter(e -> e.getValue() > 300)
				.sorted((a,b) -> a.getTrader().getCity().compareTo(b.getTrader().getCity()))
				.collect(toList());
		
		//	3. What are all the unique cities where the traders work?
		List<String> q3 = transactions.stream().map(e -> e.getTrader().getCity()).distinct()
				.collect(toList());
		
		//	4. Find all traders from Cambridge and sort them by name desc.
		List<Trader> q4 =  transactions.stream()
				.filter(e -> "Cambridge".equals(e.getTrader().getCity()))
				.map(Transaction::getTrader).sorted(comparing(Trader::getName).reversed())
				.collect(toList());
		
		//	5. Return a string of all traders’ names sorted alphabetically.
		String q5 = transactions.stream().map(e -> e.getTrader().getName()).distinct()
				.sorted(comparing(identity()))
				.reduce("", (a, b) -> a += (" " + b)).trim();
		
		//	6. Are any traders based in Milan?
		List<Trader> q6 = transactions.stream().map(Transaction::getTrader).distinct()
				.filter(e -> "Milan".equals(e.getCity())).collect(toList());
		
		//	7. Count the number of traders in Milan.
		Long q7 = transactions.stream().map(Transaction::getTrader).distinct()
				.filter(e -> "Milan".equals(e.getCity())).count();
		
		//	8. Print all transactions’ values from the traders living in Cambridge.
		List<Integer> q8 = transactions.stream()
				.filter(e -> "Cambridge".equals(e.getTrader().getCity()))
				.map(Transaction::getValue).collect(toList());
		
		//	9. What’s the highest value of all the transactions?
		OptionalInt q9 = transactions.stream()
				.mapToInt(Transaction::getValue).max();
		
		//	10. Find the transaction with the smallest value.
		OptionalInt q10 = transactions.stream()
				.mapToInt(Transaction::getValue).min();
		
	}
	
	private static <T> void printf(List<T> list) {
		list.forEach(System.out::println);
	}
	
	private static List<Transaction> initData() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2011, 950));
		return transactions;
	}
}
