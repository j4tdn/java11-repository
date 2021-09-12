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
import utils.DataUtils;
import utils.FileUtils;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	private static final String TRANSACTION_PATH = "transaction.txt";

	public static void main(String[] args) throws IOException {
		// write, export traderList, TransactionList to txt
//		File traderFile = FileUtils.create(TRADER_PATH);
//		File transactionFile = FileUtils.create(TRANSACTION_PATH);
//
//		List<Trader> traders = DataUtils.getTrader();
//
//		FileUtils.writeLines(traderFile.toPath(), traders, StandardOpenOption.APPEND);
//
//		FileUtils.open(traderFile);
//		

		// readdata
		Path path = Paths.get(TRADER_PATH);
		

		List<Trader> traders = FileUtils.ReadLines(path, Trader::new);
		System.out.println(traders);

	}
}
