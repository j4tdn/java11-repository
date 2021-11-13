package practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
		List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
		// Q1:
		List<Transaction> Q1 = transactions.stream().filter(t -> t.getYear() == 2011).sorted()
				.collect(Collectors.toList());
		// Q2:
		List<Transaction> Q2 = transactions.stream().filter(t -> t.getValue() > 300)
				.sorted((o1, o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity()))
				.collect(Collectors.toList());
		// Q3:
		Set<String> Q3 = new HashSet<>();
		for (Trader item : traders) {
			Q3.add(item.getCity());
		}
		for (String item : Q3) {
			System.out.println(item);
		}
		// Q4
		List<Trader> Q4 = traders.stream().filter(t -> t.getCity().equals("Cambridge"))
				.sorted(Comparator.comparing(Trader::getName, Comparator.reverseOrder())).collect(Collectors.toList());

	}
}
