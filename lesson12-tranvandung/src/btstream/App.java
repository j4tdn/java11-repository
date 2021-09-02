package btstream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

		// 1: Find all transactions in year 2011 and sort them by value
		List<Transaction> year2011Sort = transactions.stream()
					.sorted(Comparator.comparing(Transaction::getValue))
					.filter(tran -> tran.getYear() == 2011)
					.collect(Collectors.toList());
		System.out.println("==1==");
		Utils.printf(year2011Sort);

		// 2: find all transactions have value greater than 300 and sort them by trader's city
		List<Transaction> valGr300Sort = transactions.stream()
					.sorted((o1, o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity()))
					.filter(tran -> tran.getValue() > 300)
					.collect(Collectors.toList());
		System.out.println("==2==");
		Utils.printf(valGr300Sort);

		// 3: what are all the unique cities where the trader work
		List<String> cityWork = traders.stream()
					.map(Trader::getCity)
					.distinct()
					.collect(Collectors.toList());
		System.out.println("==3==");
		Utils.printf(cityWork);

		// 4: find the traders from Cambridge and sort them by name desc
		List<Trader> tradCam = traders.stream()
					.sorted(Comparator.comparing(Trader::getName).reversed())
					.filter(trad -> trad.getCity().equals("Cambridge"))
					.collect(Collectors.toList());
		System.out.println("==4==");
		Utils.printf(tradCam);

		// 5: Return a string of all traders's names sorted alphabetically
		List<String> tradNameSort = traders.stream()
					.map(Trader::getName)
					.sorted()
					.collect(Collectors.toList());
		System.out.println("==5==");
		Utils.printf(tradNameSort);

		// 6: Are any traders based in Milan
		boolean tradMil = traders.stream()
					.anyMatch(trad -> trad.getCity().equals("Milan"));
		System.out.println("==6==");
		System.out.println(tradMil);

		// 7: Count the number of traders in Milan
		long countTradMil = traders.stream()
					.filter(trad -> trad.getCity().equals("Milan"))
					.count();
		System.out.println("==7==");
		System.out.println(countTradMil);

		// 8: print all transactions'value from the traders living in Cambride
		List<Transaction> tranValCam = transactions.stream()
					.filter(tran -> tran.getTrader().getCity().equals("Cambridge"))
					.collect(Collectors.toList());
		System.out.println("==8==");
		Utils.printf(tranValCam);

		// 9: what's the highest value of all the transaction value
		double highestValTran = transactions.stream()
					.mapToDouble(Transaction::getValue)
					.reduce(0d, Double::max);
		System.out.println("==9==");
		System.out.println(highestValTran);

		// 10: Find the transaction with the smallest value
		Optional<Transaction> smallestValTran = transactions.stream()
					.sorted(Comparator.comparing(Transaction::getValue))
					.findFirst();
		System.out.println("==10==");
		System.out.println(smallestValTran);

	}
}
