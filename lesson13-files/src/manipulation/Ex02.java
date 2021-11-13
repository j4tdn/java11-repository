package manipulation;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import Utils.FileUtils;
import common.Trader;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	private static final String TRANSACTION_PATH = "transaction.txt";

	public static void main(String[] args) throws IOException {

//		Write data Input >> List<T> <==> Output >> Write file successful

//		File traderFile = FileUtils.create(TRADER_PATH);
//		File TransactionFile = FileUtils.create(TRANSACTION_PATH);
//		
//		List<Trader> traders = DataUtils.getTrader();
//		FileUtils.writeLines(traderFile.toPath(), traders, StandardOpenOption.APPEND);
//		FileUtils.open(traderFile);
//		
//		
//		List<Transaction> transactions = DataUtils.getTransaction();
//		FileUtils.writeLines(TransactionFile.toPath(),transactions,StandardOpenOption.APPEND);
//		FileUtils.open(TransactionFile);

		// Read data Input >>File >> Lines <==> List<T>
		Path path = Paths.get(TRADER_PATH);
		List<Trader> traders = FileUtils.readLines(path, Trader::toObject);
		System.out.println(traders);

	}

}