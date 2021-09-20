package Utils;

import java.util.Arrays;
import java.util.List;

import common.Trader;
import common.Transaction;

public class DataUtils {
	
	
	public static List<Trader> getTrader(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		return Arrays.asList(raoul, mario, alan, brian);
	}
		public static List<Transaction> getTransaction(){
			Trader raoul = new Trader("Raoul", "Cambridge");
			Trader mario = new Trader("Mario", "Milan");
			Trader alan = new Trader("Alan", "Cambridge");
			Trader brian = new Trader("Brian", "Cambridge");
			return Arrays.asList(new Transaction(brian, 2011, 300),
					new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400),
					new Transaction(mario, 2012, 710), new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));
			
		}
	
}
