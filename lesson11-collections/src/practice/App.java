package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import utils.CollectionUtils;

public class App {
	// traders executing transactions
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
		Q1(transactions);
		System.out.println("==========");
		Q2(transactions);
		System.out.println("==========");
		Q3(traders);
		System.out.println("==========");
		Q4(traders);
	}

	private static void Q1(List<Transaction> transactions) {
		List<Transaction> arr = new ArrayList<>();
		for(Transaction transaction: transactions) {
			if (transaction.getYear() == 2011) {
				arr.add(transaction);
			}
		}
		
		arr.sort(Comparator.comparing(Transaction::getValue));
		CollectionUtils.printf(arr);
	}
	
	private static void Q2(List<Transaction> transactions) {
		List<Transaction> arr = new ArrayList<>();
		for(Transaction transaction: transactions) {
			if (transaction.getValue() > 300) {
				arr.add(transaction);
			}
		}
		
		Comparator<Transaction> comp = (o1, o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity());
		
		arr.sort(comp);
		CollectionUtils.printf(arr);
	}
	
	private static void Q3(List<Trader> traders) {
		Set<String> cities = new HashSet<>();
		for(Trader trader: traders) {
			cities.add(trader.getCity());
		}
		
		for (String city: cities) {
			System.out.println(city); 
		}
	}
	
	private static void Q4(List<Trader> traders) {
		List<Trader> arr = new ArrayList<>();
		for(Trader trader: traders) {
			if ("Cambridge".equals(trader.getCity())) {
				arr.add(trader);
			}
		}
		arr.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));

		
		CollectionUtils.printf(arr);
	}
	
	private static Map<Integer, String> sort(Map<Integer, String> model){
		List<Entry<Integer, String>> arr = new LinkedList<>(model.entrySet());
		arr.sort(Entry.comparingByValue(Comparator.reverseOrder()));;
		
		Map<Integer, String> sortedMap = new LinkedHashMap<>();
		for(Entry<Integer, String> entry: arr) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap; 
	}
}