package manipulation;
import java.io.File;
import java.util.List;
import common.Trader;
import utils.DataUtils;
import utils.FileUtils;

public class Ex03 {
	private static final String TRADER_PATH = "trader.txt";
	public static void main(String[] args) {
		File file = new File(TRADER_PATH);
		 List<Trader> traders = DataUtils.getTraders();
		 FileUtils.writeObjects(file, traders);
		 FileUtils.open(file);
		 System.out.println("=======");
		
		List<Trader> traderss = FileUtils.readObject(file);
		System.out.println(traderss);
	}
}
