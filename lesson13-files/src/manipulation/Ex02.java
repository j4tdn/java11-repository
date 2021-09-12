package manipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import common.Trader;
import common.Transaction;
import utils.DataUtils;
import utils.FileUtils;

public class Ex02 {
	private static final String TRANSACTION_PATH = "transaction.txt";
	private static final String TRADER_PATH = "trader.txt";
	public static void main(String[] args) throws IOException {
		// Write data: Input >> List<T> <==> Output >> Write file successfull
		// File transactionFile = FileUtils.create(TRANSACTION_PATH);
		// List<Transaction> transactions = DataUtils.getTransactions();
 		// FileUtils.writeLines(transactionFile.toPath(), transactions, StandardOpenOption.APPEND);
 		// FileUtils.open(transactionFile);
		
		// Read data: Input >> File >> Line <==> Output: List<T> 
		Path path = Paths.get(TRADER_PATH);
		List<String> lines = Files.readAllLines(path);
		
		// line: Cambridge, Raoul
		List<Trader> traders = lines.stream()
								    .map(Trader::toObject)
								    .collect(Collectors.toList()); // Trader::new
		System.out.println(traders);
	}
}
