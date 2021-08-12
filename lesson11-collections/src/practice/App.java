package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import utils.CollectionUtils;

public class App {
	// traders executing transactions
	public static void main(String[] args) {

		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		System.out.println("=========================");
		CollectionUtils.printf(highestValue(transactions));

		System.out.println("=========================");
		CollectionUtils.printf(findMin(transactions));
		System.out.println("=========================");
		System.out.println("=========================");

		System.out.println("Find all transactions in year 2012 and sort them by value (small to high)");

		// Find all transactions in year 2012 and sort them by value (small to high)
		List<Transaction> tYear = new ArrayList<>();
		for (Transaction trs : transactions) {
			if (trs.getYear() == 2012) {
				tYear.add(trs);

			}
		}
		tYear.sort(Comparator.comparing(t -> t.getValue()));
		CollectionUtils.printf(tYear);
		System.out.println("============1=============");

		// Find all transactions have value greater than 300 and sort them by trader's
		// city
		List<Transaction> tv300 = new ArrayList<>();
		for (Transaction trs : transactions) {
			if (trs.getValue() > 300) {
				tv300.add(trs);

			}
		}
		Comparator<Transaction> comp = new Comparator<Transaction>() {

			@Override
			public int compare(Transaction o1, Transaction o2) {
				return o2.getTrader().getCity().compareTo(o1.getTrader().getCity());
			}
		};
		tv300.sort(comp);
		CollectionUtils.printf(tv300);
		System.out.println("===========2============");

		// What are all the unique cities where the traders work
		Set<String> cities = new HashSet<>();
		for (Trader trader : traders) {
			cities.add(trader.getCity());
		}
		for (String city : cities) {
			System.out.println(city);
		}
		System.out.println("============3===========");

		// Find all traders from Cambridge and sort them by name desc
		List<Trader> traderFromCam = new ArrayList<>();
		for (Trader trader : traders) {
			if (trader.getCity().equals("Cambridge")) {
				traderFromCam.add(trader);
			}
		}
		traderFromCam.sort(Comparator.comparing(t -> t.getName(), Comparator.reverseOrder()));
		CollectionUtils.printf(traderFromCam);
		System.out.println("===========4============");

		// Return a string of all trader's names sorted by alphabetically.
		Set<String> traderName = new TreeSet<>();
		for (Trader trader : traders) {
			traderName.add(trader.getName());
		}
		Comparator<String> compString = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};

		for (String str : traderName) {
			System.out.println(str);
		}
		System.out.println("===========5=============");

		System.out.println(checkMilan(traders));
		System.out.println(countMilan(traders));

		// Print all transactions' value from the trader living in Cambridge
		List<Transaction> valueOfCam = new ArrayList<>();
		valueOfCam = valueOfCam(transactions);

		CollectionUtils.printf(valueOfCam);

	}

	// Are any trader based in Milan?
	private static boolean checkMilan(List<Trader> traders) {
		for (Trader trd : traders) {
			if (trd.getCity().equals("Milan")) {
				return true;
			}
		}
		return false;
	}

	// Count the number of traders in Milan
	private static int countMilan(List<Trader> traders) {
		int count = 0;
		for (Trader trd : traders) {
			if (trd.getCity().equals("Milan")) {
				count++;
			}
		}
		return count;
	}

	// Print all transactions' value from the trader living in Cambridge
	private static List valueOfCam(List<Transaction> transactions) {
		List<Transaction> valueOfCam = new ArrayList<Transaction>();
		for (Transaction tran : transactions) {
			if (tran.getTrader().getCity().equals("Cambridge")) {
				valueOfCam.add(tran);
			}
		}
		return valueOfCam;
	}

	// What's the highest value of all the transactions
	private static List highestValue(List<Transaction> transactions) {
		List<Integer> value = new ArrayList<Integer>();
		for (Transaction tran : transactions) {
			value.add(tran.getValue());
		}
		Integer max = Collections.max(value);
		List<Transaction> maxValue = new ArrayList<Transaction>();
		for (Transaction tran : transactions) {
			if (tran.getValue() == max) {
				maxValue.add(tran);
			}
		}
		return maxValue;
	}

	// Find the transaction with the smallest value
	private static List findMin(List<Transaction> transactions) {
		List<Integer> value = new ArrayList<>();
		for(Transaction tran : transactions) {
			value.add(tran.getValue());
		}
		Integer min = Collections.min(value);
		List<Transaction> smallestValue = new ArrayList<>();
		for(Transaction tran : transactions) {
			if(tran.getValue() == min) {
				smallestValue.add(tran);
			}
		}
		return smallestValue;
	}
}