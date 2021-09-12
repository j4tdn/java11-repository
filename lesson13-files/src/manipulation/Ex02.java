package manipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

import common.Trader;
import common.Transaction;
import utils.DataUtils;
import utils.FileUtils;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	// private static final String TRANSACTION_PATH = "transaction.txt";

	public static void main(String[] args) throws IOException {
		// write, Export TraderList, TransactionList to txt file

		// Write data: Input >> List<T> <==> Output
		// File traderFile = FileUtils.create(TRAN);
		// File transactionsFile = FileUtils.create(TRANSACTION_PATH);

		// List<Transaction> transactions = DataUtils.getTransactions();

		// FileUtils.writeLines(transactionsFile.toPath(), transactions,
		// StandardOpenOption.APPEND);
		// FileUtils.open(transactionsFile);

		// Read data: Input >> File >> Lines <==> Output: List<T>
		Path path = Paths.get(TRADER_PATH);
		List<Trader> traders = FileUtils.readLines(path, Trader::new);
	}
}
