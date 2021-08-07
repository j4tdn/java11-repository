package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

		// cau 1 :
		List<Transaction> ty2021 = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getYear() == 2021) {
				ty2021.add(transaction);
			}
		}

		ty2021.sort(Comparator.comparing(Transaction::getValue));
		CollectionUtils.printf(ty2021);

		System.out.println("===================");

		List<Transaction> v300 = new ArrayList<>();
		for (Transaction transaction : transactions) {
			if (transaction.getValue() > 300) {
				v300.add(transaction);
			}
		}

		v300.sort((o1, o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity()));
		CollectionUtils.printf(v300);

		System.out.println("=======================");

		Set<String> city = new HashSet<>();
		for (Trader trader : traders) {
			city.add(trader.getCity());
		}

		for (String c : city) {
			System.out.println(c);
		}
		
		System.out.println("===================");
		
		List<Trader> t4 = new ArrayList<>();
		for (Trader trader : traders) {
			if (trader.getCity().equals("Cambridge")) {
				t4.add(trader);
			}
		}
		
		t4.sort(Comparator.comparing(Trader::getName, Comparator.reverseOrder()));
		CollectionUtils.printf(t4);
	}

}
