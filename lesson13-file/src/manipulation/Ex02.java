package manipulation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import common.Trader;
import utils.FileUtils;

public class Ex02 {
	
    private static final String TRANSACTION_PATH = "trader.txt";

	public static void main(String[] args) throws IOException {
		// Write data: Input >> List<T> <==> Output >> Write file successful
		
		// File transactionsFile = FileUtils.create(TRANSACTION_PATH);
		// List<Transaction> transactions = DataUtils.getTransaction();
		// FileUtils.writeLines(transactionsFile.toPath(), transactions, StandardOpenOption.APPEND);
		// FileUtils.open(transactionsFile);
        
		// Read data: Input >> File >> Lines <==> Output: List<T>
		
		Path path = Paths.get(TRANSACTION_PATH);
		List<Trader> transactions = FileUtils.readLines(path, Trader::new);
        System.out.println(transactions);
	}
}