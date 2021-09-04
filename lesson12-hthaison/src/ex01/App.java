package ex01;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import bean.Trader;
import bean.Transaction;
import utils.TransactionUtils;

public class App {
	public static void main(String[] args) {
		List<Transaction> trans = TransactionUtils.getAll();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Mode: ");
		int mode = -1;
		while(mode != 0) {
			mode = sc.nextInt();
			switch(mode) {
			case 1:
				System.out.println("Find all transactions in the year 2011 and sort them by value (small to high).");
				Ex01(trans).forEach(System.out::println);
				break;
			case 2:
				System.out.println("Find all transactions have value greater than 300 and sort them by trader’s city");
				Ex02(trans).forEach(System.out::println);
				break;
			case 3:
				System.out.println("What are all the unique cities where the traders work?");
				for(Transaction i: Ex03(trans)) {
					System.out.println(i.getTrader().getCity());
				}
				break;
			case 4:
				System.out.println("Find all traders from Cambridge and sort them by name desc.");
				Ex04(trans).forEach(System.out::println);
				break;
			case 5:
				System.out.println("Return a string of all traders’ names sorted alphabetically.");
				System.out.println(Ex05(trans));
				break;
			case 6:		
				System.out.println("Are any traders based in Milan?");
				System.out.println(Ex06(trans));
				break;
			case 7:
				System.out.println("Count the number of traders in Milan.");
				System.out.println(Ex07(trans));
				break;
			case 8:
				System.out.println("Print all transactions’ values from the traders living in Cambridge.");
				System.out.println(Ex08(trans));
				break;
			case 9:
				System.out.println("What’s the highest value of all the transactions?");
				System.out.println(Ex09(trans));
				break;
			case 10:
				System.out.println("Find the transaction with the smallest value.");
				System.out.println(Ex10(trans));
				break;
			}
		}
	}
	private static List<Transaction> Ex01(List<Transaction> trans) {
		return  trans.stream().filter(item -> item.getYear() == 2011)
				 .sorted(Comparator.comparing(Transaction::getValue))
				 .collect(Collectors.toList());
	}
	private static List<Transaction> Ex02(List<Transaction> trans){
		
		return trans.stream().filter(item-> item.getValue() > 300)
					.sorted((s1,s2) -> s1.getTrader().getCity().compareTo(s2.getTrader().getCity()))
					.collect(Collectors.toList());
	}
	private static Set<Transaction> Ex03(List<Transaction> trans){
		
		return trans.stream()
					.collect(Collectors.toCollection(() 
							-> new TreeSet<>((o1,o2) -> o1.getTrader().getCity()
											  .compareTo(o2.getTrader().getCity()))));
						
	}
	private static List<String> Ex04 (List<Transaction> trans){
		return trans.stream()
					.map(Transaction::getTrader)
					.filter(item -> item.getCity().equals("Cambridge"))
					.sorted((s1,s2) -> s1.getName().compareTo(s1.getName()))
					.map(Trader::getName)
					.collect(Collectors.toList());
	}
	private static String Ex05 (List<Transaction> trans){
		return trans.stream()
					.map(Transaction::getTrader)
					.map(Trader::getName)
					.distinct()
					.sorted()
					.reduce("",(a,b)-> a+=(" " +b)).trim();
	}
	private static boolean Ex06(List<Transaction> trans) {
		
		return  trans.stream()		
					 .map(Transaction::getTrader)
					 .anyMatch(item -> item.getCity().equals("Milan"));		
	}
	private static long Ex07(List<Transaction> trans) {
		return trans.stream()
					.map(Transaction::getTrader)
					.filter(item -> item.getCity().equals("Milan"))
					.distinct()
					.count();
	}
	
	private static List<Integer> Ex08(List<Transaction> trans){
		return trans.stream()
					.map(Transaction::getValue)
					.collect(Collectors.toList());
	}
	private static int Ex09(List<Transaction> trans) {
		return trans.stream()
					.mapToInt(Transaction::getValue)
					.max().getAsInt();
	}
	private static int Ex10(List<Transaction> trans) {
		return trans.stream()
					.mapToInt(Transaction::getValue)
					.min().getAsInt();
	}
	
	

	

}
