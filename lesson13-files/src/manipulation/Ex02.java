package manipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import common.Trader;
import utils.FileUtils;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	
	public static void main(String[] args) throws IOException{
		// Write data: Input >> List<T> <==> Output >> Write file successful
		// File transactionFile = FileUtils.create(TRANSACTION_PATH);
		// List<Transaction> transactions = DataUtils.getTransactions();
		// FileUtils.writeLines(transactionFile.toPath(), transactions, StandardOpenOption.APPEND);
		// FileUtils.open(transactionFile);
		
		// Read data: Input >> File >> Lines <==> Output: List<T>
		Path path = Paths.get(TRADER_PATH);
		List<Trader> traders = FileUtils.readLines(path, Trader::new);
		System.out.println(traders);
	}
}
