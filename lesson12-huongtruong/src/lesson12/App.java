package lesson12;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class App {
	public static <T> void main(String[] args) {
		List<Transaction> transactions = getAll();

		System.out.println("==========ex1=======================");

		List<Transaction> ex1 = transactions.stream().filter(t -> 2011 == t.getYear())
				.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());

		ex1.forEach(System.out::println);
		System.out.println("===============ex2=================");

		List<Transaction> ex2 = transactions.stream().filter(t -> t.getValue() > 300)
				.sorted((t1, t2) -> t1.getTrader().getCity().compareTo(t2.getTrader().getCity()))
				.collect(Collectors.toList());

		ex2.forEach(System.out::println);
		System.out.println("============ex3=================");

		Set<String> ex3 = transactions.stream().map(t -> t.getTrader().getCity()).collect(Collectors.toSet());

		ex3.forEach(System.out::println);
		System.out.println("============ex4=================");

		Set<Trader> ex4 = transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
				.sorted((t1, t2) -> t1.getTrader().getName().compareTo(t2.getTrader().getName()))
				.map(t -> t.getTrader()).collect(Collectors.toSet());

		ex4.forEach(System.out::println);
		System.out.println("==============ex5===================");

		Set<String> ex5 = transactions.stream().map(t -> t.getTrader().getName()).sorted((t1, t2) -> t1.compareTo(t2))
				.collect(Collectors.toSet());

		ex5.forEach(System.out::println);
		System.out.println("============ex6=============");

		Optional<Transaction> ex6 = transactions.stream().filter(t -> "Milan".equals(t.getTrader().getCity()))
				.findAny();

		System.out.println("Ex6 : " + ex6.get());
		System.out.println("============ex7==============");

		Long ex7 = transactions.stream().filter(t -> "Milan".equals(t.getTrader().getCity())).count();

		System.out.println("ex7 size : " + ex7);
		System.out.println("=============ex8================");

		Set<Transaction> ex8 = transactions.stream().filter(t -> "Cambridge".equals(t.getTrader().getCity()))
				.collect(Collectors.toSet());

		ex8.forEach(System.out::println);
		System.out.println("=============ex9====================");

		Optional<Integer> ex9 = transactions.stream().sorted(Comparator.comparing(Transaction::getValue).reversed())
				.map(t -> t.getValue()).findFirst();

		System.out.println("Highest value is  : " + ex9.get());
		System.out.println("================ex10===================");

		Optional<Transaction> ex10 = transactions.stream().sorted(Comparator.comparing(Transaction::getValue))
				.findFirst();

		System.out.println("The transaction with smallest value is : " + ex10.get());

	}

	private static List<Transaction> getAll() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		return Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}
}