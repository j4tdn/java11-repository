package app;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;
import utils.CollectionUtils;
import utils.TransactionUtils;

public class App {
	public static void main(String[] args) {
		List<Transaction> trans = TransactionUtils.getTransactionAll();
		List<Trader> traders = TransactionUtils.getTraderAll();
		
		System.out.println("1. Transactions in 2011 & sort ascending by value");
		List<Transaction> ex01 = trans.stream()
								.filter(tran -> tran.getYear() == 2011)
								.sorted(Comparator.comparing(Transaction::getValue))
								.collect(Collectors.toList());
		CollectionUtils.printf(ex01);
		
		System.out.println("2. Transactions value > 300 & sort ascending by trader’s city");
		List<Transaction> ex02 = trans.stream()
								.filter(tran -> tran.getValue() > 300)
								.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
								.collect(Collectors.toList());
		CollectionUtils.printf(ex02);
		
		System.out.println("3. What are all the unique cities where merchants work");
		List<String> ex03 = traders.stream()
								.filter(trader -> Collections.frequency(traders, trader) == 1)
								.map(Trader::getCity)
								.collect(Collectors.toList());
		CollectionUtils.printf(ex03);
		
		System.out.println("4. Find all traders from Cambridge and sort them by name desc");
		List<Trader> ex04 = traders.stream()
								.filter(trader -> "Cambridge".equalsIgnoreCase(trader.getCity()))
								.sorted(Comparator.comparing(Trader::getName).reversed())
								.collect(Collectors.toList());
		CollectionUtils.printf(ex04);
		
		System.out.println("5. Return a string of all traders’ names sorted alphabetically");
		List<String> ex05 = traders.stream()
								.map(Trader::getName)
								.sorted()
								.collect(Collectors.toList());
		CollectionUtils.printf(ex05);
		
		System.out.println("6. Are any traders based in Milan?");
		boolean ex06 = traders.stream()
								.anyMatch(trader -> "Milan".equalsIgnoreCase(trader.getCity()));
		System.out.println((ex06 == true ? "yes" : "no") + "\n");
		
		System.out.println("7. Count the number of traders in Milan");
		long ex07 = traders.stream()
								.filter(trader -> "Milan".equalsIgnoreCase(trader.getCity()))
								.count();
		System.out.println(ex07 + "\n");
		
		System.out.println("8. Print all transactions’ values from the traders living in Cambridge");
		List<Integer> ex08 = trans.stream()
								.filter(tran -> "Cambridge".equalsIgnoreCase(tran.getTrader().getCity()))
								.map(Transaction::getValue)
								.collect(Collectors.toList());
		System.out.println(ex08 + "\n");
		
		System.out.println("9. What’s the highest value of all the transactions");
		int ex09 = trans.stream()
						.map(Transaction::getValue)
						.reduce(Integer.MIN_VALUE, Math::max);
		System.out.println(ex09 + "\n");
		
		System.out.println("10. Find the transaction with the smallest value");
		Optional<Transaction> ex10 = trans.stream()
							.sorted(Comparator.comparing(Transaction::getValue))
							.findFirst();
		System.out.println(ex10);
	}
}
