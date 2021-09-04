package app;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;
import utils.Utils;

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
		
		//1 Find all transactions in the year 2011 and sort them by value
		List<Transaction> sortYear2011 = transactions.stream()
													 .filter(t -> t.getYear() == 2011)
													 .sorted(Comparator.comparing(Transaction::getValue))
													 .collect(Collectors.toList());
		Utils.printf(sortYear2011);		
		System.out.println("===========");
		
		//2 Find all transactions have value greater than 300 and sort them by trader’s city
		List<Transaction> valueGr300 = transactions.stream()
												   .filter(t -> t.getValue() > 300)
												   .sorted((t1,t2)-> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
												   .collect(Collectors.toList());
		Utils.printf(valueGr300);
		System.out.println("===========");
		
		//3 What are all the unique cities where the traders work?
		List<String> city = traders.stream()
								   .map(trader -> trader.getCity())
								   .distinct()
								   .collect(Collectors.toList());
		Utils.printf(city);
		System.out.println("===========");
		
		//4 Find all traders from Cambridge and sort them by name desc.
		List<Trader> traderCambridge = traders.stream()
				 								.filter(trader -> trader.getCity().equals("Cambridge"))
				 								.sorted(Comparator.comparing(Trader::getName))
				 								.collect(Collectors.toList());
		Utils.printf(traderCambridge);		
		System.out.println("===========");
		
		//5 Return a string of all traders’ names sorted alphabetically.
		List<String> sortTraderName = traders.stream()
											 .map(trader -> trader.getName())
											 .sorted()
											 .collect(Collectors.toList());
		Utils.printf(sortTraderName);
		System.out.println("==============");
		
		//6 Are any traders based in Milan?
		boolean isTraderMilan = traders.stream()
									   .anyMatch(trader -> trader.getCity().equals("Milan"));
		System.out.println(isTraderMilan);
		System.out.println("==========");
		
		//7 Count the number of traders in Milan
		long countTraderMilan = traders.stream()
										 .filter(trader -> trader.getCity().equals("Milan"))
										 .count();
		System.out.println(countTraderMilan);
		System.out.println("================");
		
		//8 Print all transactions’ values from the traders living in Cambridge.
		List<Integer> tranVlCambridge = transactions.stream()
													.filter(trader -> trader.getTrader().getCity().equals("Cambridge"))
													.map(t -> t.getValue())
													.collect(Collectors.toList());
		Utils.printf(tranVlCambridge);
		System.out.println("==============");
		
		//9 What’s the highest value of all the transactions?
		//10 Find the transaction with the smallest value.
	}
}
