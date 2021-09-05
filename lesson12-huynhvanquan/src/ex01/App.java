package ex01;

import static java.util.function.Function.identity;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;

public class App {
	public static void main(String[] args) {
		List<Transaction> transactions = getData();
		question1(transactions);
		question2(transactions);
		question3(transactions);
		question4(transactions);
		question5(transactions);
		question6(transactions);
		question7(transactions);
		question8(transactions);
		question9(transactions);
		question10(transactions);
	}

	private static List<Transaction> getData() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		return Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}
	
	// Question 1: Find all transactions in the year 2011 and sort them by value (small to high)
	private static void question1(List<Transaction> transactions) {
		List<Transaction> q1 = transactions.stream()
										   .filter(transaction -> transaction.getYear() == 2011)
										   .sorted(Comparator.comparingInt(Transaction::getValue))
										   .collect(Collectors.toList());
		System.out.println("Question 1 - Result\n---");
		Utils.printf(q1);
	}
	
	// Question 2: Find all transactions have value greater tha 300 and sort them by trader's city
	private static void question2(List<Transaction> transactions) {
		List<Transaction> q2 = transactions.stream()
											.filter(transaction -> transaction.getValue() > 300)
											.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
											.collect(Collectors.toList());
		System.out.println("\nQuestion 2 - Result\n---");
		Utils.printf(q2);
	}
	
	// Question 3: What are all the unique cities where the trader work?
	private static void question3(List<Transaction> transactions) {
		List<String> q3 = transactions.stream()
									  .map(transaction -> transaction.getTrader().getCity())
									  .distinct()
									  .collect(Collectors.toList());
		System.out.println("\nQuestion 3 - Result\n---");
		Utils.printf(q3);
	}
	
	// Question 4: Find all traders from Cambridge and sort them by name desc 
	private static void question4(List<Transaction> transactions) {
		List<Trader> q4 = transactions.stream()
									  .map(Transaction::getTrader)
									  .filter(trader -> trader.getCity().equals("Cambridge"))
									  .sorted(Comparator.comparing(Trader::getName).reversed())
									  .distinct()
									  .collect(Collectors.toList());
		System.out.println("\nQuestion 4 - Result\n---");
		Utils.printf(q4);
	}
	
	// Question 5: Return a string of all trader's names sorted alphabetically 
	private static void question5(List<Transaction> transactions) {
		String q5 = transactions.stream()
							    .map(transaction -> transaction.getTrader().getName())
							    .sorted((s1, s2) -> s1.compareTo(s2))
							    .distinct()
							    .reduce("", (name1, name2) -> name1 += (" " + name2)).trim();
		System.out.println("\nQuestion 5 - Result\n---");
		System.out.println(q5);
	}
	// Question 6: Are any traders based in Milan?
	private static void question6(List<Transaction> transactions) {

		boolean q6 = transactions.stream()
		            			 .anyMatch(transaction -> "Milan".equals(transaction.getTrader().getCity()));
		System.out.println("\nQuestion 6 - Result\n---");
		System.out.println(q6);
	}
	// Question 7: Count the number of traders in Milan 
	private static void question7(List<Transaction> transactions) {
		long q7 = transactions.stream()
				              .map(transaction -> transaction.getTrader())
				              .filter(trader -> "Milan".equals(trader.getCity()))
				              .distinct()
				              .count();
		System.out.println("\nQuestion 7 - Result\n---");
		System.out.println(q7);
	}
	// Question 8: Print all transaction's value from the traders living in Cambridge
	private static void question8(List<Transaction> transactions) {
		List<Integer> q8 = transactions.stream()
				              .filter(transaction -> "Cambridge".equals(transaction.getTrader().getCity()))
				              .map(Transaction::getValue)
				              .collect(Collectors.toList());
		System.out.println("\nQuestion 8 - Result\n---");
		Utils.printf(q8);
	}
	// Question 9: What's the highest value of all the transactions?
	private static void question9(List<Transaction> transactions) {
		Integer q9 = transactions.stream()
							  .map(Transaction::getValue)
				              .reduce(0, Integer::max);
		System.out.println("\nQuestion 9 - Result\n---");
		System.out.println("Max value: " + q9);
	}
	// Question 10: What's the highest value of all the transactions?
	private static void question10(List<Transaction> transactions) {
		Optional<Transaction> transactionOpt = transactions.stream().reduce(Transaction::minTransaction);
		System.out.println("\nQuestion 10 - Result\n---");
		transactionOpt.ifPresent(System.out::println);
	}
}
