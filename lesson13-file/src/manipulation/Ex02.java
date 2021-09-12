package manipulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import common.Trader;
import common.Transaction;
import utils.DataUtils;
import utils.FileUtils;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	private static final String TRANSACTION_PATH = "transaction.txt";
	
	public static void main(String[] args) throws IOException {
		// Write data : Input >> data 	
//		File transactionFile =  FileUtils.create(TRANSACTION_PATH);	
//		List<Transaction> transactions = DataUtils.getTransactions();	
//		FileUtils.writeLine(transactionFile.toPath(), transactions, StandardOpenOption.APPEND);	
//		System.out.println("Write file successful !!!");
		
		// Read data : Input >> File >> Lines <==> Output : List<T>
		Path path = Paths.get(TRADER_PATH);
		List<String> lines =  Files.readAllLines(path);
		
//		List<Trader> traders =  lines.stream()
//				.map(Trader::toObject).collect(Collectors.toList());
		
		List<Trader> traderss = FileUtils.readLines(path, Trader::toObject);
		System.out.println();
	}
}
