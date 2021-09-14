package manipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

import common.Trader;
import common.Transaction;
import utils.DataUtils;
import utils.FileUtils;

public class Ex03 {
	private static final String TRADER_PATH = "trader.txt";
	private static final String TRANSACTION_PATH = "transaction.txt";

	public static void main(String[] args) {
		File file = new File(TRADER_PATH);
//		List<Trader> traders = DataUtils.getTraders();
//		FileUtils.writeObject(file, traders);
 
		File fileTrans = new File(TRANSACTION_PATH);
		// List<Transaction> transactions = DataUtils.getTransactions();
		// FileUtils.writeObject(fileTrans, transactions);
		// FileUtils.open(fileTrans);

//		List<Trader> traders = FileUtils.readObject(file);
//		System.out.println(traders);
//		FileUtils.open(file);
		
		List<Transaction> transactions = FileUtils.readObject(fileTrans);
		transactions.forEach(System.out::println);
	}
}
