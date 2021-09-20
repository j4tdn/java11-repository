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

import Utils.DataUtils;
import Utils.FileUtils;
import common.Trader;

public class Ex02 {
	private static final String TRADER_PATH = "trader.txt";
	
		public static void main(String[] args) throws IOException {
		//Write Data: Input >> List<T> <==> Output >> Write file successful		
//			File traderFile = FileUtils.create(TRADER_PATH);
//			
//			List<Trader> traders = DataUtils.getTrader();
//			FileUtils.writeLines(traderFile.toPath(), traders, StandardOpenOption.APPEND);
//			
//			FileUtils.open(traderFile);
 		
		//Read Data Input >> File >> Lines is <String> <==> List<T>
			
			
		Path path = Paths.get(TRADER_PATH);
		List<String> lines =   Files.readAllLines(path);
		List<Trader> traders = FileUtils.readLines(path, Trader::new);
		//line: Cambridge, Raoul 
			System.out.println(traders);
		
		}
}
