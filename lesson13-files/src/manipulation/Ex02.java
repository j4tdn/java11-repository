package manipulation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import common.Trader;
import common.Transaction;
import utils.FileUtils;

public class Ex02 {
	
	private static final String TRANSACTION_PATH = "transaction.txt";
	private static final String TRADER_PATH = "trader.txt";
	
	public static void main(String[] args) throws IOException {
		// Write data: Input >> List<T> <==> Output >> write file successful
		// File transactionFile = FileUtils.create(TRANSACTION_PATH);
	    // List<Transaction> transactions = DataUtils.getTransactions();	
	    // FileUtils.writeLines(transactionFile.toPath(), transactions, StandardOpenOption.APPEND);
	    // FileUtils.open(transactionFile);
		
		// Read data: Input >> File >> Lines <==> Output: List<T>
//		Path path = Paths.get(TRADER_PATH);
//		List<Trader> traders = FileUtils.readLines(path, Trader::new);
//		traders.forEach(System.out::println);
		
		Path pathTransac = Paths.get(TRANSACTION_PATH);
		List<Transaction> transactions = FileUtils.readLines(pathTransac, Transaction::new);
		transactions.forEach(System.out::println);
		
	}
}
