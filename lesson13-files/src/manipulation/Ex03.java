package manipulation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import Utils.DataUtils;
import Utils.FileUtils;
import common.Trader;

public class Ex03 {
	
	private static final String TRADER_PATH = "trader.txt";
	
	public static void main(String[] args) {
		File file = new File(TRADER_PATH);

		
		  List<Trader> input = DataUtils.getTrader(); 
		  FileUtils.writeObject(file,
		  input);
		 
		System.out.println("======================");
		
		
		List<Trader> traders = FileUtils.readObject(file);
		FileUtils.open(file);
		System.out.println(traders);
		
	}
}
