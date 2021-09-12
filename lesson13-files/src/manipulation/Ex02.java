package manipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import common.Trader;
import utils.FileUtils;

public class Ex02 {

	private static final String TRANSACTION_PATH = "transaction.txt";
	private static final String TRADER_PATH = "trader.txt";

	public static void main(String[] args) throws IOException {
		// write data: Input >> List<T> <==> Output >> Write file successful
//		File transactionFile = FileUtils.create(TRANSACTION_PATH);
//		List<Transaction> transactions = DataUtils.getTransaction();
//		FileUtils.writeLines(transactionFile.toPath(), transactions, StandardOpenOption.APPEND);
//		FileUtils.open(transactionFile);

		// Read data: Input >> File >> Lines <==> Output: List<T>
		Path path = Paths.get(TRANSACTION_PATH);
		List<Trader> transactions = FileUtils.readLines(path, Trader::new);
        System.out.println(transactions);

	}

}
