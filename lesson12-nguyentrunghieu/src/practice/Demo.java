package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;

import static java.util.Comparator.*;
public class Demo {
	// traders executing transactions
	public static void main(String[] args) {

		List<Transaction> transactions = getTransactions();
		List<Trader> traders=getTraders();
		
		// todo: implement code here
		//cau 1
		List<Transaction> findTransactionsIn2011 = transactions.stream()
															   .filter(transaction -> transaction.getYear() == 2011)
															   .sorted(comparing(Transaction::getValue))
															   .collect(Collectors.toList());
		System.out.println("----------------Cau 1-----------------");
		System.out.println(findTransactionsIn2011);
		//cau 2
		List<Transaction> transactionsValueGreater300 = transactions.stream()
				   .filter(transaction -> transaction.getValue()>300)
				   .sorted(comparing(transaction -> transaction.getTrader().getCity()))
				   .collect(Collectors.toList());
		System.out.println("----------------Cau 2-----------------");
		System.out.println(transactionsValueGreater300);
		//cau 3
		Map<String, Integer> UniqueCity = new HashMap<>();
		traders.stream().forEach(trader -> {
			String city = trader.getCity();
			if (UniqueCity.get(city) != null && UniqueCity.get(city).equals(UniqueCity.get(city))) {
				UniqueCity.put(city, UniqueCity.get(city)+1);
			}
			else {
			UniqueCity.put(city, 1);
		}
		});
		List<String> uniqueCities = UniqueCity.entrySet()
				.stream()
				.filter(entry -> entry.getValue() == 1)
				.map(Entry::getKey)
				.collect(Collectors.toList());
		System.out.println("----------------Cau 3-----------------");
		System.out.println(UniqueCity);
		//cau 4
		List<Trader> findAllTraderCambridge = traders.stream()
				 .filter(trader -> "Cambridge".equals(trader.getCity()))
				 .collect(Collectors.toList());
		System.out.println("----------------Cau 4-----------------");
		System.out.println(findAllTraderCambridge);
		//cau 5
		List<String> traderNames = traders.stream()
				 .map(Trader::getName)
				 .sorted()
				 .collect(Collectors.toList());
		String names = String.join(" - ", traderNames);
		System.out.println("----------------Cau 5-----------------");
		System.out.println(names);
		//cau 6
		boolean anyTraderInMilan = traders.stream().anyMatch(trader-> "Milan".equals(trader.getCity()));
		System.out.println("----------------Cau 6-----------------");
		System.out.println(anyTraderInMilan);
		//cau 7
		long numberOfTradersInMilan = traders.stream()
										   .filter(trader -> "Milan".equals(trader.getCity())).count();
		System.out.println("----------------Cau 7-----------------");
		System.out.println(numberOfTradersInMilan);
		//cau 8
		System.out.println("----------------Cau 8-----------------");		
		transactions.stream()
					.filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
					.forEach(transaction -> System.out.println(transaction.getValue()));
		//cau 9
		Optional<Integer> max = transactions.stream()
				   .map(Transaction::getValue)
				   .reduce((a,b) -> a>b?a :b);
		System.out.println("----------------Cau 9-----------------");
		System.out.println(max);
		//cau 10
		Optional<Integer> min = transactions.stream()
				   .map(Transaction::getValue)
				   .reduce((a,b) -> a<b?a :b);
		System.out.println("----------------Cau 10-----------------");
		System.out.println(min);
		// todo: result
		
		
	}
	
	
	private static List<Transaction> getTransactions() {
		List<Trader> traders = getTraders();
		return Arrays.asList(
				new Transaction(traders.get(3), 2011, 300),
				new Transaction(traders.get(0), 2012, 1000),
				new Transaction(traders.get(0), 2011, 400),
				new Transaction(traders.get(1), 2012, 710),
				new Transaction(traders.get(1), 2012, 700),
				new Transaction(traders.get(2), 2012, 950)
		);
	}

	private static List<Trader> getTraders() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		return Arrays.asList(raoul, mario, alan, brian);
	}

}
