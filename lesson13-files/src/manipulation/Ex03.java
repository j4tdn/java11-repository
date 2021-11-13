package manipulation;

import java.io.File;
import java.util.List;

import common.Trader;
import Utils.DataUtils;
import Utils.FileUtils;

public class Ex03 {
	private static final String TRADER_PATH = "trader.txt";

	public static void main(String[] args) {
		List<Trader> traders = DataUtils.getTrader();

		File file = new File(TRADER_PATH);
		// FileUtils.writeObject(file,traders);

		List<Trader> a = FileUtils.readObject(file);
		System.out.println(a);
	}
}