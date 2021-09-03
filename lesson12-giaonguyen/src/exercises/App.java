package exercises;

import java.util.Arrays;
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

		List<Transaction> sort2021Y = transactions.stream()
				.sorted(Comparator.comparing(Transaction::getValue))
				.filter(a -> a.getYear() == 2011)
				.collect(Collectors.toList());			
		System.out.println("Ex1: Find all transactions in the year 2011 and sort them by value (small to high).");
		StreamUtils.printf(sort2021Y);

		List<Transaction> getValueGrt300 = transactions.stream()	
				.sorted((o1,o2) -> o1.getTrader().getCity().compareTo(o2.getTrader().getCity()))
				.filter(a -> a.getValue() > 300)			
				.collect(Collectors.toList());			
		System.out.println("Ex2: Find all transactions have value greater than 300 and sort them by");
		StreamUtils.printf(getValueGrt300);
		
		List<String> getUniqCity = traders.stream()	
				.map(Trader::getCity)
				.distinct()		
				.collect(Collectors.toList());	
		System.out.println("Ex3: What are all the unique cities where the traders work");
		StreamUtils.printf(getUniqCity);
		
		List<Trader> getTDfrCam = traders.stream()	
				.sorted(Comparator.comparing(Trader::getName).reversed())
				.filter(a -> a.getCity().equals("Cambridge"))		
				.collect(Collectors.toList());	
		System.out.println("Ex4: Find all traders from Cambridge and sort them by name desc");
		StreamUtils.printf(getTDfrCam);
		
		List<String> getAllName = traders.stream()	
				.map(Trader::getName)
				.sorted()		
				.collect(Collectors.toList());	
		System.out.println("Ex5: Return a string of all traders’ names sorted alphabetically");
		StreamUtils.printf(getAllName);
		
		Optional<Trader> isTDfrMil = traders.stream()	
				.filter(trad -> trad.getCity().equals("Milan"))
				.findAny();
		System.out.println("Ex6: Are any traders based in Milan?");
		System.out.println(isTDfrMil.isPresent());
		
		long getMountTDfrMil = traders.stream()
				.filter(a -> a.getCity().equalsIgnoreCase("milan"))
				.count();
		System.out.println("Ex7: Count the number of traders in Milan");
		System.out.println(getMountTDfrMil);
		
		List<Transaction> getAllTDfrCam = transactions.stream()	
				.filter(a -> a.getTrader().getCity().equals("Cambridge"))			
				.collect(Collectors.toList());			
		System.out.println("Ex8: Print all transactions’ values from the traders living in Cambridge");
		StreamUtils.printf(getAllTDfrCam);
		
		int getValueMax = transactions.stream()
				.map(Transaction::getValue)
				.reduce(0, Integer::max);
		System.out.println("Ex9: What’s the highest value of all the transactions?");
		System.out.println("Max value: " + getValueMax);
		
		List<Transaction> getTDValueMin = transactions.stream()	
				.sorted(Comparator.comparing(Transaction::getValue))
				.collect(Collectors.toList());	
		System.out.println("Ex10: Find the transaction with the smallest value");
		System.out.println(getTDValueMin.get(0));
	}										
}
