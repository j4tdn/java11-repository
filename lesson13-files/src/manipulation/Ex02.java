package manipulation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import common.Trader;
import utils.FileUtils;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	private static final String TRANSACTION_PATH = "transaction.txt";

	public static void main(String[] args) throws IOException {
//		Write Files

//		File traderFile = FileUtils.create(TRADER_PATH);
//		List<Trader> traders = DataUtils.getTraders();
//		File transactionFile = FileUtils.create(TRANSACTION_PATH);
//		List<Transaction> transactions = DataUtils.getTransactions();
//		FileUtils.writeLines(transactionFile.toPath(), transactions, StandardOpenOption.APPEND);

//		Read Files
		Path path = Paths.get(TRADER_PATH);
		List<Trader> traders = FileUtils.readLines(path, Trader::toObject);
		System.out.println(traders);
	}

}
